package com.JOffre.daoUtil;
import com.JOffre.Model.City;
import com.JOffre.Model.Offre;


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
    public static Offre mapToOffer(ResultSet resultSet)throws SQLException{
            Offre offer = new Offre();
            offer.setOfferId( resultSet.getLong( "offerId" ) );
            offer.setTitre( resultSet.getString("title"));
            offer.setIdUser( resultSet.getString("idUser"));
            offer.setDescription(resultSet.getString("description"));
            resultSet.getInt("city");
            offer.setCity(City.CASA);
            offer.setCity(resultSet.getObject("category"));
            offer.setCity(resultSet.getObject("date"));

            /*

    private String[] photos;
    private String userFirstName;
    private String userLastName;
    private Integer score;*/

            return offer;
    }
}

