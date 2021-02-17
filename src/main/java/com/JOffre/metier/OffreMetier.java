package com.JOffre.metier;

import com.JOffre.dao.OffreDaoImpl;
import com.JOffre.metier.Entities.Offre;

import java.sql.SQLException;
import java.util.List;


public class OffreMetier {
    public static void main(String[] args) throws SQLException {

        OffreDaoImpl dao = new OffreDaoImpl();
        Offre p1 = dao.save(new Offre("HP 6580","Electronique","Imprimante tres bonne","Anas","Tanger","NULL"));
        Offre p2 = dao.save(new Offre("Cannon","Electronique","Imprimante tres bonne","Hamid","Tanger","NULL"));
        Offre p3 = dao.save(new Offre("Sony 120","Electronique","Imprimante tres bonne","Salman","Tanger","NULL"));
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println("Chercher des Offre:");
        List<Offre> prods= dao.OffreParMc("%E%");
        for(Offre p :prods){
            System.out.println(p.toString());
        }
    }

}
