package com.JOffre.dao;

import com.JOffre.Model.Category;
import com.JOffre.Model.City;
import com.JOffre.Model.Offre;
import static com.JOffre.daoUtil.Util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OffreDaoImpl implements IOffreDao{

    private static final String SQL_INSERT = "INSERT INTO offer(idUser, title, description, date, city, category) VALUES(?,?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT offerId, idUser, title, description, date, city, category from offer where offerId = ? ";
    private static final String SQL_UPDATE = "UPDATE offer set title  = ?, description = ?, city = ?, category = ?  where offerId = ? ";
    private static final String SQL_DELETE = "DELETE from offer where offerId = ? ";

    private DaoFactory          daoFactory;
    Connection connection= null;
    PreparedStatement preparedStatement = null;


    OffreDaoImpl( DaoFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Offre create(Offre offer) throws DaoException {
        ResultSet generatedValues = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_INSERT, true, offer.getIdUser(), offer.getTitre(), offer.getDescription(), offer.getDate(), cityToInt( offer.getCity() ), categoryToInt( offer.getCategory() ) );

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot add an offer to table" );
            }

            //recuperation de l'id
            generatedValues = preparedStatement.getGeneratedKeys();
            if ( generatedValues.next() ) {
                offer.setOfferId( generatedValues.getLong( 1 ) );
            } else {
                throw new DaoException("failed to create an offer, no id was generated");
            }
        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( generatedValues, preparedStatement, connection );
        }
        return offer;
    }

    @Override
    public Offre get(Long id) throws DaoException {
        Offre offer = null;
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_SELECT, false, id);

            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if ( resultSet.next() ) {
                offer = mapToOffer(resultSet);
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( resultSet, preparedStatement, connection );
        }
        return offer;
    }



    @Override
    public Offre update(Offre offer) throws DaoException {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_UPDATE, true, offer.getTitre(), offer.getDescription(), offer.getCity(), offer.getCategory());

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot update an offer" );
            }
        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( preparedStatement, connection );
        }
        return offer;
    }

    @Override
    public void delete(Long id) throws DaoException {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_DELETE, false, id);

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot delete an offer" );
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources(preparedStatement, connection );
        }
    }

    @Override
    public List<Offre> getOffres(City city) throws DaoException {
        return null;
    }

    @Override
    public List<Offre> getOffres(int category) throws DaoException {
        return null;
    }

    @Override
    public List<Offre> getOffres(City city, Category category) throws DaoException {
        return null;
    }

    @Override
    public List<Offre> searchOffers(String str) throws DaoException {
        return null;
    }


}
