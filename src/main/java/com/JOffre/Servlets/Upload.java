package com.JOffre.Servlets;

import com.JOffre.Model.Category;
import com.JOffre.Model.City;
import com.JOffre.Model.Offre;
import com.JOffre.dao.DaoFactory;
import com.JOffre.dao.IOffreDao;
import com.JOffre.dao.IUserDao;
import com.JOffre.metier.OfferFormUpload;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Upload extends HttpServlet {

    private static final String VIEW              = "/WEB-INF/upload.jsp";

    private static final String ATT_DAO_FACTORY   = "daofactory";
    private static final String ATT_OFFER         = "offers";

    private static final String STORE_PATH        = "path";



    private IOffreDao offerDao = null;
    private IUserDao userDao = null;
    private List<Offre> offers;
    private Offre offer ;

    @Override
    public void init() throws ServletException{
        this.offerDao = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getOfferDao();
        this.userDao = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getUserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        offers = this.offerDao.getOffres(City.RABAT);
        request.setAttribute(ATT_OFFER, offers);
        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getting the path to where to store from configuration and web.xml
        String path = this.getServletConfig().getInitParameter( STORE_PATH );

        //init a metier that handle the comming offer form
        OfferFormUpload offerFormUploader = new OfferFormUpload() ;

        //using metier to process and get back with processed bean offer
        offer = offerFormUploader.storeOffer(request, path);

        //using Dao to store the bean
        this.offerDao.create(offer);

        request.setAttribute("form", offerFormUploader);
        request.setAttribute("offer", offer);
        //the jsp can access the errors with offerFormUploader.errors["file"]

        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
    }




}
