package com.JOffre.Servlets;

import com.JOffre.Model.City;
import com.JOffre.Model.Offre;
import com.JOffre.dao.DaoFactory;
import com.JOffre.dao.IOffreDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/offers")
public class Offers extends HttpServlet {
    private static final String ATT_DAO_FACTORY = "daofactory";
    private static final String ATT_OFFERS      = "offers";
    private static final String VIEW            = "/WEB-INF/offers.jsp";
    private IOffreDao offers                    = null;

    @Override
    public void init() throws ServletException{
        this.offers = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getOfferDao();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Offre> offers = this.offers.searchOffers("car");

        request.setAttribute(ATT_OFFERS, offers);
        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
