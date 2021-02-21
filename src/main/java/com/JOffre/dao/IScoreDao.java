package com.JOffre.dao;

import com.JOffre.Model.Offre;


//Consider in implementing DOWN AND UPS ARE STORED IN DATABASE AS  signle Char of Values 'D' 'U' 'N' means(down up neutral) ==> example :comparison using str.chatAt(0) == 'U'
public interface IScoreDao {
    Integer get( Long offerId ) throws DaoException; //return score of an offer
    Integer updateOrCreate( String idUser, Offre offer, char value) throws DaoException; //update the score of an offer 'D','N','U'
}
