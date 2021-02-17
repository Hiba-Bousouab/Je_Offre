package com.JOffre.dao;
import com.JOffre.metier.Entities.Offre;

import java.sql.SQLException;
import java.util.List;

public interface IOffreDao {
    public Offre save(Offre p);
    public List<Offre> OffreParMc(String mc) throws SQLException;
    public Offre getOffre(Long id);
    public Offre update(Offre p);
    public Offre deleteOffre(Long id);
}
