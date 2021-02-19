package com.JOffre.dao;


import com.JOffre.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.JOffre.daoUtil.Util.*;

public class UserDaoImpl implements IUserDao{
    private static final String SQL_INSERT = "INSERT INTO user(idUser, firstName, lastName) VALUES(?,?,?)";
    private static final String SQL_SELECT = "SELECT idUser, firstName, lastName from user where idUser = ? ";
    private static final String SQL_UPDATE = "UPDATE user SET  firstName = ?, lastName = ? where idUser = ? ";
    private static final String SQL_DELETE = "DELETE FROM user WHERE idUser = ? ";

    private DaoFactory       daoFactory;
    Connection connection               = null;
    PreparedStatement preparedStatement = null;

    public UserDaoImpl(DaoFactory factory){ this.daoFactory = factory; }

    @Override
    public User create(User user) throws DaoException {
        ResultSet generatedValues = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_INSERT, true, user.getIdUser(), user.getFirstName(), user.getLastName() );

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot add a user" );
            }

            //recuperation de l'id
            generatedValues = preparedStatement.getGeneratedKeys();
            if ( generatedValues.next() ) {
                user.setIdUser( generatedValues.getString( 1 ) );
            } else {
                throw new DaoException("failed to create a user");
            }
        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( generatedValues, preparedStatement, connection );
        }
        return user;
    }

    @Override
    public User get(String id) throws DaoException {
        User user = null;
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_SELECT, false, id);

            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if ( resultSet.next() ) {
                user = mapToUser(resultSet);
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( resultSet, preparedStatement, connection );
        }
        return user;

    }

    @Override
    public User update(User user) throws DaoException {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_UPDATE, true, user.getFirstName(), user.getFirstName(), user.getIdUser() );

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot update a user" );
            }
        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( preparedStatement, connection );
        }
        return user;
    }

    @Override
    public void delete(String id) throws DaoException {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_DELETE, false, id );

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot delete a user" );
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources(preparedStatement, connection );
        }
    }
}



