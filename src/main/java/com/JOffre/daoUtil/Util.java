package com.JOffre.daoUtil;
import com.JOffre.Model.*;


import java.sql.*;

public class Util {
    //to prepare statement sql is the SQL request, returnGeneratedKey =true means return the generated key, object enter how many objects you need
    //example initPreparedStatement( connexion, requeteSQL, true, email, password, name, validationDate );

    public static PreparedStatement initPreparedStatement(Connection connexion, String sql, boolean returnGeneratedKeys, Object... objets ) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        }
        return preparedStatement;
    }

    //util closing resources variants
    //to close a result set
    public static void closeResources(ResultSet resultSet){
        if ( resultSet != null ) {
            try {
                resultSet.close();
            } catch ( SQLException e ) {
                System.out.println( "Cannot close ResultSet : " + e.getMessage() );
            }
        }
    }
    public static void closeResources( Statement statement ) {
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException e ) {
                System.out.println( "Cannot close Statement : " + e.getMessage() );
            }
        }
    }
    public static void closeResources( Connection connection ) {
        if ( connection != null ) {
            try {
                connection.close();
            } catch ( SQLException e ) {
                System.out.println( "Cannot close  connection : " + e.getMessage() );
            }
        }
    }
    public static void closeResources( Statement statement, Connection connexion ) {
        closeResources( statement );
        closeResources( connexion );
    }
    public static void closeResources( ResultSet resultSet, Statement statement, Connection connexion ) {
        closeResources( resultSet );
        closeResources( statement );
        closeResources( connexion );
    }
    public static Offre mapToOffer_withUserName(ResultSet resultSet)throws SQLException{
            Offre offer = new Offre();
            offer.setOfferId( resultSet.getLong( "offerId" ) );
            offer.setTitre( resultSet.getString("title") );
            offer.setIdUser( resultSet.getString("idUser") );
            offer.setDescription( resultSet.getString("description") );
            offer.setCity( intToCity( resultSet.getInt("city") ) );
            offer.setCategory( intToCategory( resultSet.getInt("category") ) );
            offer.setDate( resultSet.getTimestamp("date") );
            offer.setUserFirstName( resultSet.getString("firstName") );
            offer.setUserLastName( resultSet.getString("lastName") );
            /*
            photos
            score;*/
            return offer;
    }
    public static Offre mapToOffer_withNoUserName(ResultSet resultSet)throws SQLException{
        Offre offer = new Offre();
        offer.setOfferId( resultSet.getLong( "offerId" ) );
        offer.setTitre( resultSet.getString("title") );
        offer.setIdUser( resultSet.getString("idUser") );
        offer.setDescription( resultSet.getString("description") );
        offer.setCity( intToCity( resultSet.getInt("city") ) );
        offer.setCategory( intToCategory( resultSet.getInt("category") ) );
        offer.setDate( resultSet.getTimestamp("date") );
            /*
            photos
            score;*/
        return offer;
    }

    public static User mapToUser(ResultSet resultSet)throws SQLException{
        User user = new User();
        user.setIdUser( resultSet.getString("idUser") );
        user.setFirstName( resultSet.getString("firstName") );
        user.setLastName( resultSet.getString("lastName") );
        return user;
    }
    public static Image mapToImage(ResultSet resultSet) throws SQLException{
        Image image = new Image();
        image.setImageId( resultSet.getLong("imageId") );
        image.setOfferId( resultSet.getLong("offerId") );
        image.setPathToImage( resultSet.getString("pathToImage") );
        return image;
    }

    //conversion between Integer and enum City
    public static Integer cityToInt(City city){ return city.ordinal();}

    public static City intToCity(Integer n){return City.values()[n];}

    //conversion between Integer and enum City
    public static Integer categoryToInt(Category category){ return category.ordinal();}

    public static Category intToCategory(Integer n){return Category.values()[n];}
}

