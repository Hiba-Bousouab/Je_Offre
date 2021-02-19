package com.JOffre.dao;

import com.JOffre.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDaoImpl implements IUserDao{
    private static final String SQL_INSERT = "INSERT INTO offer(idUser, title, description, date, city, category) VALUES(?,?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT offerId, idUser, title, description, date, city, category from offer where offerId = ? ";
    private static final String SQL_UPDATE = "UPDATE offer set title  = ?, description = ?, city = ?, category = ?  where offerId = ? ";
    private static final String SQL_DELETE = "DELETE from offer where offerId = ? ";

    private DaoFactory          daoFactory;
    Connection connection= null;
    PreparedStatement preparedStatement = null;

    public UserDaoImpl(DaoFactory factory){ this.daoFactory = factory; }

    @Override
    public User create(User user) throws DaoException {
        return null;
    }

    @Override
    public User update(User user) throws DaoException {
        return null;
    }

    @Override
    public void delete(User user) throws DaoException {

    }

    @Override
    public User get(String id) throws DaoException {
        return null;
    }
}
