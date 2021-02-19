package com.JOffre.dao;

import com.JOffre.Model.Offre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.JOffre.daoUtil.Util.*;
import static com.JOffre.daoUtil.Util.closeResources;

public class ScoreDaoImpl implements IScoreDao {
    private static final String SQL_SELECT_SCORE = "SELECT rate FROM Ratings WHERE offerId = ? ";
    private static final String SQL_SELECT = "SELECT rate FROM Ratings WHERE idUser = ? and offerId = ?";
    private static final String SQL_INSERT = "INSERT INTO Ratings(idUser, offerId, rate) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Ratings SET  rate = ? WHERE idUser = ? and offerId = ? ";


    private DaoFactory       daoFactory;
    Connection connection               = null;
    PreparedStatement preparedStatement = null;
    public ScoreDaoImpl(DaoFactory factory){ this.daoFactory = factory; }


    @Override
    public Integer get(Long offerId) throws DaoException {
        ResultSet resultSet = null;
        Integer score = 0;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_SELECT_SCORE, false, offerId);
            resultSet = preparedStatement.executeQuery();

            while ( resultSet.next() ) {
                String rateChar = resultSet.getString("rate");
                if( rateChar.charAt(0) == 'U' ){
                    score++;
                }else if( rateChar.charAt(0) == 'D' ){
                    score--;
                }
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( resultSet, preparedStatement, connection );
        }
        return score;
    }

    @Override
    public Integer updateOrCreate(String idUser, Offre offer, char value) throws DaoException {
        ResultSet resultSet = null;
        Integer score = offer.getScore();
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initPreparedStatement( connection, SQL_SELECT, false, idUser, offer.getOfferId() );

            resultSet = preparedStatement.executeQuery();

            if( resultSet.next() ) {
                char oldRate = resultSet.getString("rate").charAt(0);
                preparedStatement = initPreparedStatement(connection, SQL_UPDATE, false, value, idUser, offer.getOfferId() );
                preparedStatement.executeUpdate();
                //since this offer was already scored by this user we have 5 possible scenarios -1,-1,0,+1,+2
                //0 if old == value
                // +1  if ( old == 'D' and value == 'N') or (old == N and value == U )
                // -1  if ( old == N  and value == D) or ( old == U and value == N )
                // +2  if ( old == D and value = U)
                // -2 if( old == U and value == D )
                if(oldRate != value){
                    if( ( oldRate == 'D' && value == 'N') || ( oldRate == 'N' && value == 'U' ) ) score++;
                    if( ( oldRate == 'N' && value == 'D') || ( oldRate == 'U' && value == 'N' ) ) score--;
                    if( oldRate == 'D' && value == 'U') score += 2;
                    if( oldRate == 'U' && value == 'D') score -= 2;
                }
            }else{
                preparedStatement = initPreparedStatement(connection, SQL_INSERT, false, idUser, offer.getOfferId(), value);
                preparedStatement.executeUpdate();
                if(value == 'U') score++;
                else if(value == 'D') score--;
            }

        } catch(SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResources( resultSet, preparedStatement, connection );
        }

        return score ;
    }
}
