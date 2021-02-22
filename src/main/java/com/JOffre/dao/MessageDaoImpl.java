package com.JOffre.dao;

import com.JOffre.Model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static com.JOffre.daoUtil.Util.*;
import static com.JOffre.daoUtil.Util.closeResources;

public class MessageDaoImpl implements IMessageDao {

    private static final String SQL_INSERT = "INSERT INTO Messages(sender_id_user, idUser, dateMessage, message) VALUES(?,?,?,?)";
    private static final String SQL_SELECT = "SELECT sender_id_user, idUser, id_message, dateMessage, message from Messages where sender_id_user = ? or idUser = ? ";
    private static final String SQL_DELETE = "DELETE from Messages where id_message = ? ";


    private DaoFactory       daoFactory;
    Connection connection               = null;
    PreparedStatement preparedStatement = null;

    MessageDaoImpl( DaoFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Message create(Message message) throws DaoException {
        ResultSet generatedValues = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_INSERT, true, message.getSenderId(), message.getReceiverId(), message.getDateMessage(), message.getMessage() );

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot add an message to table" );
            }

            //recuperation de l'id
            generatedValues = preparedStatement.getGeneratedKeys();
            if ( generatedValues.next() ) {
                message.setMessageId( generatedValues.getLong( 1 ) );
            } else {
                throw new DaoException("failed to create a message, no id was generated");
            }
        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( generatedValues, preparedStatement, connection );
        }
        return message;
    }

    @Override
    public List<Message> getMessages(String idUser) throws DaoException {
        List<Message> messages = new LinkedList<>();
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_SELECT, false, idUser, idUser);
            resultSet = preparedStatement.executeQuery();

            while ( resultSet.next() ) {
                messages.add( mapToMessage(resultSet) );
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( resultSet, preparedStatement, connection );
        }
        return messages;
    }

    @Override
    public void delete(Long messageId) throws DaoException {
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_DELETE, false, messageId);

            int status = preparedStatement.executeUpdate();
            if ( status == 0 ) {
                throw new DaoException( "cannot delete a message" );
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources(preparedStatement, connection );
        }
    }
}
