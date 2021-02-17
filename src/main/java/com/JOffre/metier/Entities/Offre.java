package com.JOffre.metier.Entities;

import java.io.Serializable;

public class Offre implements Serializable {

    private Long id;
    private String Titre;
    private String Designation;
    private String Description;
    private String Proprietaire;
//    private DateTime Date_pub;
//    private DateTime DAte_fin;
    private String Ville;
    private String Photo;

    public Offre() {
        super();
    }

    public Offre(String titre, String designation, String description, String proprietaire, String ville, String photo) {
        Titre = titre;
        Designation = designation;
        Description = description;
        Proprietaire = proprietaire;
        Ville = ville;
        Photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getProprietaire() {
        return Proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        Proprietaire = proprietaire;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "Titre='" + Titre + '\'' +
                ", Designation='" + Designation + '\'' +
                ", Description='" + Description + '\'' +
                ", Proprietaire='" + Proprietaire + '\'' +
                ", Ville='" + Ville + '\'' +
                ", Photo='" + Photo + '\'' +
                '}';
    }
}
