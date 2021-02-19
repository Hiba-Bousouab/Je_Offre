package com.JOffre.dao;

import com.JOffre.Model.Image;
import com.JOffre.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.JOffre.daoUtil.Util.*;
import static com.JOffre.daoUtil.Util.closeResources;

public class IImagesDaoImpl implements IImagesDao {

    private static final String SQL_INSERT = "INSERT INTO Images(offerId, pathToImage) VALUES(?, ?)";
    private static final String SQL_SELECT = "SELECT imageId, offerId , pathToImage from Images where imageId = ? ";
    private static final String SQL_DELETE = "DELETE FROM images WHERE imageId = ? ";
    private static final String SQL_SELECT_LIST_BY_OFFER = "SELECT imageId, offerId , pathToImage FROM Images WHERE offerId = ?";


    private DaoFactory       daoFactory;
    Connection connection               = null;
    PreparedStatement preparedStatement = null;

    public IImagesDaoImpl(DaoFactory factory){ this.daoFactory = factory; }

    @Override
    public Image create(Image image) throws DaoException {
        ResultSet generatedValues = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_INSERT, true, image.getOfferId(), image.getPathToImage() );

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot add an image" );
            }

            //recuperation de l'id
            generatedValues = preparedStatement.getGeneratedKeys();
            if ( generatedValues.next() ) {
                image.setImageId( generatedValues.getLong( 1 ) );
            } else {
                throw new DaoException("failed to create an image");
            }
        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( generatedValues, preparedStatement, connection );
        }
        return image;
    }

    @Override
    public Image get(Long id) throws DaoException {
        Image image = null;
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_SELECT, false, id);

            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if ( resultSet.next() ) {
                image = mapToImage(resultSet);
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( resultSet, preparedStatement, connection );
        }
        return image;

    }


    @Override
    public void delete(Long id) throws DaoException {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_DELETE, false, id );

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot delete an image" );
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources(preparedStatement, connection );
        }
    }


    @Override
    public List<Image> getAll(Long offerId) {
        List<Image> images = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_SELECT_LIST_BY_OFFER, false, offerId);

            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if ( resultSet.next() ) {
                images.add( mapToImage(resultSet) );
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( resultSet, preparedStatement, connection );
        }
        return images;

    }
}
