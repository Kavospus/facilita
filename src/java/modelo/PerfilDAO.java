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

public class PerfilDAO extends DataBaseDAO {

    public PerfilDAO() throws Exception {
    }
    
    /*Insert a Profile object to the database*/
    public void inserir(Perfil p) throws SQLException {

	PreparedStatement pst;
	String sql = "INSERT INTO perfil(perfil) VALUES(?)";
	pst = conn.prepareStatement(sql);
	pst.setString(1, p.getPerfil());
	pst.execute();

    }
    
    /*Consult a list of all Profile objects on the database*/
    public ArrayList<Perfil> listar() throws SQLException, Exception {
	MenuDAO mDB = new MenuDAO();
	ArrayList<Perfil> lista = new ArrayList<Perfil>();
	PreparedStatement pst;
	String sql = "SELECT * FROM perfil";
	pst = conn.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
	while (rs.next()) {
	    mDB.conectar();
	    Perfil p = new Perfil(rs.getInt("id"), rs.getString("perfil"),
		    mDB.menusPerfil(rs.getInt("id")));
	    mDB.desconectar();
	    lista.add(p);
	}
	return lista;

    }
    
    /*Delete a Profile object on the database*/
    public void excluir(Perfil p) throws SQLException {

	PreparedStatement pst;
	String sql = "DELETE FROM perfil WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, p.getId());
	pst.execute();

    }
    
    /*Load a Profile object with the id argument on the database*/
    public Perfil carregaPorId(int id) throws SQLException, Exception {
	Perfil p = new Perfil();
	MenuDAO mDB = new MenuDAO();
	PreparedStatement pst;
	String sql = "SELECT * FROM perfil WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, id);
	ResultSet rs = pst.executeQuery();
	if (rs.next()) {
	    p.setId(rs.getInt("id"));
	    p.setPerfil(rs.getString("perfil"));
	    mDB.conectar();
	    p.setMenus(mDB.menusPerfil(id));
	    mDB.desconectar();
	}
	return p;

    }
    
    /*Edit a Profile object on the database*/
    public void alterar(Perfil p) throws SQLException {

	PreparedStatement pst;
	String sql = "UPDATE perfil SET perfil=? WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setString(1, p.getPerfil());
	pst.setInt(2, p.getId());
	pst.execute();

    }

}
