package com.JOffre.Servlets;

import com.JOffre.dao.DaoFactory;
import com.JOffre.dao.IOffreDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/offer")
public class OfferDetail extends HttpServlet {
    private static final String ATT_DAO_FACTORY = "daofactory";
    private static final String ATT_OFFERS      = "offers";
    private static final String VIEW            = "/WEB-INF/offerDetail.jsp";
    private IOffreDao offers                    = null;

    @Override
    public void init() throws ServletException{
        this.offers = ( (DaoFactory) getServletContext().getAttribute( ATT_DAO_FACTORY ) ).getOfferDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
