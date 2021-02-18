package com.JOffre.dao;
import com.JOffre.Model.Category;
import com.JOffre.Model.City;
import com.JOffre.Model.Offre;

import java.util.List;

public interface IOffreDao {
    Offre create(Offre offer) throws DaoException;
    List<Offre> OffreParMc(String mc) throws DaoException;
    Offre get(Long id) throws DaoException;
    Offre update(Offre offer) throws DaoException;
    Offre delete(Long id) throws DaoException;

    List<Offre> getOffres(City city) throws DaoException;
    List<Offre> getOffres(Category category) throws DaoException;
    List<Offre> getOffres(City city, Category category) throws DaoException;
}
