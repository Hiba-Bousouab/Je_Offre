package com.JOffre.dao;

public class DaoException extends RuntimeException{
    public DaoException(String message){
        super(message);
    }
    public DaoException(String message, Throwable reason){
        super(message, reason);
    }
    public DaoException(Throwable reason){
        super(reason);
    }
}
