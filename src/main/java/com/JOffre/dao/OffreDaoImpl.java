package com.JOffre.dao;

import com.JOffre.metier.Entities.Offre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OffreDaoImpl implements IOffreDao {

    @Override
    public Offre save(Offre p) {
        Connection connection=SingletonConnection.getConnection();
            //Table name is key sensitive
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO Produits (TITRE,DESIGNATION,DESCRIPTION,PROPRIETAIRE,VILLE,PHOTO) VALUES(?,?,?,?,?,?)")) {
            ps.setString(1,p.getTitre());
            ps.setString(2,p.getDesignation());
            ps.setString(3,p.getDescription());
            ps.setString(4,p.getProprietaire());
            ps.setString(5,p.getVille());
            ps.setString(6,p.getPhoto());
            ps.executeUpdate();

            //pour recupere le id
            PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) as MAX_ID FROM PRODUITS");
            ResultSet rs = ps2.executeQuery();
            if(rs.next()){
                p.setId(rs.getLong("Max_ID"));
            }

            ps.close();
            ps2.close();
        } catch(SQLException e){

        }
        return p;
    }

    @Override
    public List<Offre> OffreParMc(String mc) throws SQLException {
        List<Offre> offres = new ArrayList<Offre>();
        Connection connection = SingletonConnection.getConnection();

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM Produits WHERE DESIGNATION LIKE ?");
        try {
            ps.setString(1,mc);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Offre p = new Offre();
                p.setId(rs.getLong("ID"));
                p.setTitre(rs.getString("Titre"));
                p.setDesignation(rs.getString("Designation"));
                p.setDescription(rs.getString("Description"));
                p.setProprietaire(rs.getString("Proprietaire"));
                p.setVille(rs.getString("Ville"));
                offres.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return offres;
    }

    @Override
    public Offre getOffre(Long id) {
        return null;
    }

    @Override
    public Offre update(Offre p) {
        return null;
    }

    @Override
    public Offre deleteOffre(Long id) {
        return null;
    }

}
