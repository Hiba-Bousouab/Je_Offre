package com.JOffre.dao;

//interface that helps other interfaces in some complex requests : images list, offers list, favorites...
//NOTE used mainly in OfferDao Implementation and User Dao Implementation


//not yet implemented
public interface IHelpersDao {
    String[] getImages(Long offerId);
}
