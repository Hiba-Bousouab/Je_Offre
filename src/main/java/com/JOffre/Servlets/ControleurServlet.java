package com.JOffre.Servlets;

import com.JOffre.Model.Offre;
import com.JOffre.metier.OffreMetier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vue")
public class ControleurServlet extends HttpServlet {

    private OffreMetier metier;

    @Override
    public void init() throws ServletException {
        metier = new OffreMetier();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mod",new Offre());
        request.getRequestDispatcher("Vue.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
