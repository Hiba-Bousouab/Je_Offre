package com.JOffre.dao;

import com.JOffre.beans.Offre;
import static com.JOffre.daoUtil.Util.initPreparedStatement;
import static com.JOffre.daoUtil.Util.closeResources;
import static com.JOffre.daoUtil.Util.mapToOffer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OffreDaoImpl implements IOffreDao{

    private static final String SQL_INSERT = "INSERT INTO offer(idUser, title, description, date, city, category) VALUES(?,?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT offerId, idUser, title, description, date, city, category from offer where offerId = ? ";

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
            preparedStatement = initPreparedStatement( connection, SQL_INSERT, true, offer.getTitre(),offer.getDesignation(), offer.getDescription(), offer.getProprietaire(), offer.getVille(), offer.getPhoto() );

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot add an offer to table" );
            }

            //recuperation de l'id
            generatedValues = preparedStatement.getGeneratedKeys();
            if ( generatedValues.next() ) {
                offer.setId( generatedValues.getLong( 1 ) );
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
                offer = mapToOffer( resultSet );
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
    public List<Offre> OffreParMc(String mc) throws DaoException {
        return null;
    }


    @Override
    public Offre update(Offre offer) throws DaoException {
        return null;
    }

    @Override
    public Offre delete(Long id) throws DaoException {
        return null;
    }


}
