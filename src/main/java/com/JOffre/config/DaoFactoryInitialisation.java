package com.JOffre.config;

import com.JOffre.dao.DaoFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;

//class to initialize the DAO factory when the app wake up (app works == factory works)
public class DaoFactoryInitialisation implements ServletContextListener {

    private static final String ATT_DAO_FACTORY = "daofactory";
    private DaoFactory factory;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        this.factory = DaoFactory.getFactory();

        //set attribute factory for all the app scope
        servletContext.setAttribute(ATT_DAO_FACTORY, this.factory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
