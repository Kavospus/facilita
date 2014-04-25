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
    
    /*Insert a Profile object to the database*/
    public void insert(Profile p) throws SQLException {

	PreparedStatement pst;
	String sql = "INSERT INTO perfil(perfil) VALUES(?)";
	pst = conn.prepareStatement(sql);
	pst.setString(1, p.getPerfil());
	pst.execute();

    }
    
    /*Consult a list of all Profile objects on the database*/
    public ArrayList<Profile> select() throws SQLException, Exception {
	MenuDAO mDB = new MenuDAO();
	ArrayList<Profile> lista = new ArrayList<Profile>();
	PreparedStatement pst;
	String sql = "SELECT * FROM perfil";
	pst = conn.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
	while (rs.next()) {
	    mDB.connect();
	    Profile p = new Profile(rs.getInt("id"), rs.getString("perfil"),
		    mDB.menusPerfil(rs.getInt("id")));
	    mDB.disconnect();
	    lista.add(p);
	}
	return lista;

    }
    
    /*Delete a Profile object on the database*/
    public void delete(Profile p) throws SQLException {

	PreparedStatement pst;
	String sql = "DELETE FROM perfil WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, p.getId());
	pst.execute();

    }
    
    /*Load a Profile object with the id argument on the database*/
    public Profile selectById(int id) throws SQLException, Exception {
	Profile p = new Profile();
	MenuDAO mDB = new MenuDAO();
	PreparedStatement pst;
	String sql = "SELECT * FROM perfil WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, id);
	ResultSet rs = pst.executeQuery();
	if (rs.next()) {
	    p.setId(rs.getInt("id"));
	    p.setPerfil(rs.getString("perfil"));
	    mDB.connect();
	    p.setMenus(mDB.menusPerfil(id));
	    mDB.disconnect();
	}
	return p;

    }
    
    /*Edit a Profile object on the database*/
    public void update(Profile p) throws SQLException {

	PreparedStatement pst;
	String sql = "UPDATE perfil SET perfil=? WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setString(1, p.getPerfil());
	pst.setInt(2, p.getId());
	pst.execute();

    }

}
