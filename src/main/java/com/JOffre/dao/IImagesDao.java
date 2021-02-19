package com.JOffre.dao;

import com.JOffre.Model.Image;

import java.util.List;

public interface IImagesDao {
    Image create(Image image) throws DaoException;
    Image get(Long id) throws DaoException;
    void delete(Long id) throws DaoException;
    List<Image> getAll(Long offerId) throws DaoException;
}
