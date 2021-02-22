package com.JOffre.dao;

import com.JOffre.Model.Message;

import java.util.List;

public interface IMessageDao {
    Message create(Message message) throws DaoException;
    List<Message> getMessages(String idUser) throws DaoException;
    void delete(Long messageId) throws DaoException;

}
