package com.JOffre.metier;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.JOffre.Model.Category;
import com.JOffre.Model.City;
import com.JOffre.Model.Image;
import com.JOffre.Model.Offre;

public class OfferFormUpload {
    private static final String FIELD_DESCRIPTION = "description";
    private static final String FIELD_TITLE       = "title";
    private static final String FIELD_CITY        = "city";
    private static final String FIELD_CATEGORY    = "category";
    private static final String FIELD_FILE        = "file";
    //still need to handle userId

    public static final int BUFFER_SIZE           = 10240; // 10 ko
    public static final int RANDOM_FILENAME_LEN   = 30;
    private String              result;
    private Map<String, String> errors            = new HashMap<String, String>();

    private Offre offer = new Offre();
    private Image image = new Image();

    public String getResult() {
        return result;
    }
    public Map<String, String> getErrors() {
        return errors;
    }

    public Image getImage() { return image; }
    public void setImage(Image image) { this.image = image; }
    public Offre getOffer() { return offer; }
    public void setOffer(Offre offer) { this.offer = offer; }

    public Offre storeOffer( HttpServletRequest request, String path ) {

        //getting the inputs of non file fields
        String description = getFieldValue( request, FIELD_DESCRIPTION );
        String title       = getFieldValue( request, FIELD_TITLE );
        Category category  = Category.valueOf( getFieldValue( request, FIELD_CATEGORY ) );
        City   city        = City.valueOf( getFieldValue( request, FIELD_CITY ) );

        //need userId and images


        //getting the file field using getPart
        String fileName = null;
        InputStream fileContent = null;
        try {
            //getting the file field using getPart
            Part part = request.getPart( FIELD_FILE );

            //making sure it is a file input
            fileName = getFileName( part );

            //if fileName isn't null it is really a type=file field
            if ( fileName != null && !fileName.isEmpty() ) {

                //extract fileName with no '\'  example C:\\dossier\img.jpg become img.jpg
                fileName = fileName.substring( fileName.lastIndexOf( '/' ) + 1 )
                        .substring( fileName.lastIndexOf( '\\' ) + 1 );

                //getting the file's content
                fileContent = part.getInputStream();


            }
        } catch ( IllegalStateException e ) {
            //if the file passes the limits on configuration
            e.printStackTrace();
            setError( FIELD_FILE, "File is too big" );
        } catch ( IOException e ) {
            e.printStackTrace();
            setError( FIELD_FILE, "File cannot be saved on server check configurations" );
        } catch ( ServletException e ) {
            e.printStackTrace();
            setError( FIELD_FILE, "Request type not supported please use our form to submit you dumb hacker" );
        }

        //if no error found lets validate our fields
        if ( errors.isEmpty() ) {
            //validating
            try {
                validateDescription( description );
            } catch ( Exception e ) {
                setError( FIELD_DESCRIPTION, e.getMessage() );
            }
            try {
                validateTitle( title );
            } catch ( Exception e ) {
                setError( FIELD_TITLE, e.getMessage() );
            }
            offer.setDescription( description );
            offer.setTitre(title);
            offer.setCategory(category);
            offer.setCity(city);

//            try {
//                validateFile( fileName, fileContent );
//            } catch ( Exception e ) {
//                setError( FIELD_FILE, e.getMessage() );
//            }
            image.setPathToImage( fileName );
        }
        //if no error lets now store our file in the hard disk
        if ( errors.isEmpty() ) {
            try {
                store_file( fileContent, fileName, path );
            } catch ( Exception e ) {
                setError( FIELD_FILE, "Error when storing file" );
            }
        }

        //result of the operation
        if ( errors.isEmpty() ) {
            result = "Success";
        } else {
            result = "Failed";
        }

        return offer;
    }

    //validate field description
    private void validateDescription( String description ) throws Exception {
        if ( description != null ) {
            if ( description.length() < 20 ) {
                throw new Exception( "description is too short please use a description with more than 20 characters" );
            }
        } else {
            throw new Exception( "Please enter a description" );
        }
    }
    //validate field title
    private void validateTitle( String title ) throws Exception {
        if ( title != null ) {
            if ( title.length() < 5 ) {
                throw new Exception( "title is too short please use a longer title" );
            }
        } else {
            throw new Exception( "Please enter a title" );
        }
    }

    //validating the file
    private void validateFile( String fileName, InputStream fileContent ) throws Exception {
        if ( fileName == null || fileContent == null ) {
            throw new Exception( "No file was added" );
        }
    }

    //adding errors
    private void setError( String field, String message ) {
        errors.put( field, message );
    }

    //field content to get its value method instead of getParametre that is not well done in all servers
    private static String getFieldValue( HttpServletRequest request, String fieldName ) {
        String value = request.getParameter( fieldName );
        if ( value == null || value.trim().length() == 0 ) {
            return null;
        } else {
            return value;
        }
    }


    //method that analyse the content-disposition header and look for file name presance

    private static String getFileName( Part part ) {
        //looping over paramestres of the content-disposition field of part header
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            //looking for filename presence
            if ( contentDisposition.trim().startsWith("filename") ) {
                //if file name field exist returning its value (filename=value)
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        //no filename field found return null
        return null;
    }


    //saving file in the hard drive method
    private void store_file(InputStream fileContent, String fileName, String path ) throws IOException {

        BufferedInputStream   in  = null;
        BufferedOutputStream  out = null;
        File file = null;
        try {
            //open the streams
            in = new BufferedInputStream( fileContent, BUFFER_SIZE );

            out = new BufferedOutputStream( new FileOutputStream( new File( path + random_java8_string(RANDOM_FILENAME_LEN) ) ), BUFFER_SIZE );

            byte[] buffer = new byte[BUFFER_SIZE];
            int length;
            while ( ( length = in.read( buffer ) ) > 0 ) {

                out.write( buffer, 0, length );
            }

        } finally {
            try {
                out.close();
            } catch ( IOException ignore ) { }
            try {
                in.close();
            } catch ( IOException ignore ) { }
        }
    }


    public String random_java8_string(int len) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = len;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}