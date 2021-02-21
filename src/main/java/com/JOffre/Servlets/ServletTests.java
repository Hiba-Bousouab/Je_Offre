package com.JOffre.Servlets;

import com.JOffre.Model.City;
import com.JOffre.Model.Offre;
import com.JOffre.dao.DaoFactory;
import com.JOffre.dao.IOffreDao;
import com.JOffre.dao.IUserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/tests")
public class ServletTests extends HttpServlet {

    private static final String ATT_DAO_FACTORY = "daofactory";
    private static final String ATT_OFFER      = "offer";
    private IOffreDao offerDao = null;
    private IUserDao userDao = null;
    private List<Offre> offers;

    @Override
    public void init() throws ServletException{
        this.offerDao = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getOfferDao();
        this.userDao = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getUserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        offers = this.offerDao.getOffres(City.CASABLANCA);
        request.setAttribute(ATT_OFFER, offers);
        this.getServletContext().getRequestDispatcher( "/WEB-INF/tests.jsp" ).forward( request, response );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
