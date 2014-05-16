/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Database persistence class for Profile. That includes operations
 *list,update,remove,insert into database.
 */


package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfileDAO extends DataBaseDAO {

    public ProfileDAO() throws Exception {
    }
    
    /**
     *
     * @param profile 
     * @throws SQLException
     * Insert a Profile object to the database*/
    public void insert(Profile profile) throws SQLException {

	PreparedStatement preparedStatement;
	String sql = "INSERT INTO perfil(perfil) VALUES(?)";
	preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setString(1, profile.getProfile());
	preparedStatement.execute();

    }
    /**
     *
     * @throws SQLException
     * @throws Exception
     * @return lista
     * Consult a list of all Profile objects on the database*/
    public ArrayList<Profile> select() throws SQLException, Exception {
	MenuDAO menuDB = new MenuDAO();
	ArrayList<Profile> lista = new ArrayList<Profile>();
	PreparedStatement preparedStatement;
	String sql = "SELECT * FROM perfil";
	preparedStatement = conn.prepareStatement(sql);
	ResultSet rs = preparedStatement.executeQuery();
	while (rs.next()) {
	    menuDB.connect();
	    Profile profile = new Profile(rs.getInt("id"), rs.getString("perfil"),
		    menuDB.profileMenus(rs.getInt("id")));
	    menuDB.disconnect();
	    lista.add(profile);
	}
	return lista;

    }

    /**
     *
     * @param profile 
     * @throws SQLException
    /*Delete a Profile object on the database*/
    public void delete(Profile profile) throws SQLException {

	PreparedStatement preparedStatement;
	String sql = "DELETE FROM perfil WHERE id=?";
	preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setInt(1, profile.getId());
	preparedStatement.execute();

    }
    /**
     *
     * @param id
     * @throws SQLException
     * @throws Exception
     * @return profile
     * Load a Profile object with the id argument on the database*/
    public Profile selectById(int id) throws SQLException, Exception {
	Profile profile = new Profile();
	MenuDAO menuDB = new MenuDAO();
	PreparedStatement preparedStatement;
	String sql = "SELECT * FROM perfil WHERE id=?";
	preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setInt(1, id);
	ResultSet rs = preparedStatement.executeQuery();
	if (rs.next()) {
	    profile.setId(rs.getInt("id"));
	    profile.setProfile(rs.getString("perfil"));
	    menuDB.connect();
	    profile.setMenus(menuDB.profileMenus(id));
	    menuDB.disconnect();
	}
        else{
            //Nothing to do
        }
	return profile;

    }
    /**
     *
     * @param profile
     * @throws SQLException
    /*Edit a Profile object on the database*/
    public void update(Profile profile) throws SQLException {
	PreparedStatement preparedStatement;
	String sql = "UPDATE perfil SET perfil=? WHERE id=?";
	preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setString(1, profile.getProfile());
	preparedStatement.setInt(2, profile.getId());
	preparedStatement.execute();

    }

}
