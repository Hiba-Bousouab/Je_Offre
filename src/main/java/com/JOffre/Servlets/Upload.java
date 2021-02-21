package com.JOffre.Servlets;

import com.JOffre.Model.Category;
import com.JOffre.Model.City;
import com.JOffre.Model.Offre;
import com.JOffre.dao.DaoFactory;
import com.JOffre.dao.IOffreDao;
import com.JOffre.dao.IUserDao;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Upload extends HttpServlet {

    private static final String VIEW              = "/WEB-INF/upload.jsp";

    private static final String ATT_DAO_FACTORY   = "daofactory";
    private static final String ATT_OFFER         = "offers";

    private static final String STORE_PATH        = "path";
    public static final int BUFFER_SIZE           = 10240; // 10 ko


    private static final String FIELD_DESCRIPTION = "description";
    private static final String FIELD_TITLE       = "title";
    private static final String FIELD_CITY        = "city";
    private static final String FIELD_CATEGORY    = "category";
    private static final String FIELD_FILE        = "file";

    //still userID and date before upload to databsase


    private IOffreDao offerDao = null;
    private IUserDao userDao = null;
    private List<Offre> offers;
    private Offre offer ;

    @Override
    public void init() throws ServletException{
        this.offerDao = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getOfferDao();
        this.userDao = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getUserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        offers = this.offerDao.getOffres(City.RABAT);
        request.setAttribute(ATT_OFFER, offers);
        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getting the inputs of non file fields
        String description = request.getParameter( FIELD_DESCRIPTION );
        String title       = request.getParameter( FIELD_TITLE );
        String category    = request.getParameter( FIELD_CATEGORY );
        String city        = request.getParameter( FIELD_CITY );
        request.setAttribute( FIELD_DESCRIPTION, description );
        request.setAttribute( FIELD_TITLE, title );
        request.setAttribute( FIELD_CATEGORY, category );
        request.setAttribute( FIELD_CITY, city );

        String path = this.getServletConfig().getInitParameter( STORE_PATH );

        this.offer = new Offre();
        offer.setTitre( title );
        offer.setDescription( description );
        offer.setCategory( Category.ALL );
        offer.setCity( City.RABAT );
        offer.setDate(new Timestamp(new Date().getTime()));

        //getting the file field using getPart
        Part part = request.getPart( FIELD_FILE );

        //making sure it is a file input
        String fileName = getFileName( part );

        //if fileName isn't null it is really a type=file field
        if ( fileName != null && !fileName.isEmpty() ) {
            String fieldName = part.getName();
            //extract fileName with no '\'  example C:\\dossier\img.jpg become img.jpg
            fileName = fileName.substring( fileName.lastIndexOf( '/' ) + 1 )
                    .substring( fileName.lastIndexOf( '\\' ) + 1 );

            store_file(part, fileName, path);

            request.setAttribute( FIELD_FILE, fileName );
        }

        this.offerDao.create(offer);
        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
    }

    //method that analyse the content-disposition header and look for file name presance
    private static String getFileName( Part part ) {
        //looping over paramestres of the content-disposition field of part header
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            //looking for filename presence
            if ( contentDisposition.trim().startsWith("filename") ) {
                //if file name field exist returning its value (filename=value)
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 );
            }
        }
        //no filename field found return null
        return null;
    }

    //saving file in the hard drive method
    private void store_file( Part part, String fileName, String path ) throws IOException {

        BufferedInputStream   in  = null;
        BufferedOutputStream  out = null;
        File file = null;
        try {
            //open the streams
            in = new BufferedInputStream( part.getInputStream(), BUFFER_SIZE );

            out = new BufferedOutputStream( new FileOutputStream( new File( path + fileName ) ), BUFFER_SIZE );

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

}
