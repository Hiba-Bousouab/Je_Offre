package com.JOffre.dao;

public class DaoConfigurationException extends  RuntimeException{
    public DaoConfigurationException(String message){super(message);}
    public DaoConfigurationException(String message, Throwable reason){super(message, reason);}
    public DaoConfigurationException(Throwable reason){super(reason);}
}
