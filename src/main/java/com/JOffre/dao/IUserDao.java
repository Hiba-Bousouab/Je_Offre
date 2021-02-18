package com.JOffre.dao;

import com.JOffre.Model.User;

public interface IUserDao {
    User create(User user) throws DaoException;
    User update(User user) throws DaoException;
    void delete(User user) throws DaoException;
    User get(String id) throws DaoException;
}
