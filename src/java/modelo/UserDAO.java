/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Database persistence class for User. That includes operations
 *list,update,remove,insert into database.
 */

package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO extends DataBaseDAO {

    public UserDAO() throws Exception {
    }
    
    /*Insert a User object to the database*/
    public void insert(User u) throws SQLException {

	PreparedStatement pst;
	String sql = "INSERT INTO usuario (id_perfil,login,senha,nome) "
		+ "values(?,?,?,?)";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, u.getPerfil().getId());
	pst.setString(2, u.getLogin());
	pst.setString(3, u.getSenha());
	pst.setString(4, u.getNome());
	pst.execute();

    }
    
    /*Consult a list of all User objects on the database*/
    public ArrayList<User> select() throws SQLException, Exception {

	ProfileDAO pDB = new ProfileDAO();
	ArrayList<User> lista = new ArrayList<User>();
	PreparedStatement pst;
	String sql = "SELECT * FROM usuario";
	pst = conn.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
	while (rs.next()) {
	    User u = new User();
	    u.setId(rs.getInt("id"));
	    u.setLogin(rs.getString("login"));
	    u.setSenha(rs.getString("senha"));
	    u.setNome(rs.getString("nome"));
	    pDB.connect();
	    u.setPerfil(pDB.selectById(rs.getInt("id_perfil")));
	    pDB.disconnect();
	    lista.add(u);
	}
	return lista;

    }
    
    /*Login a User object throught the user and password arguments*/
    public User logon(String user, String senha) throws SQLException,
	    Exception {
	ProfileDAO pDB = new ProfileDAO();
	PreparedStatement pst;
	String sql = "SELECT * FROM usuario WHERE login=?";
	pst = conn.prepareStatement(sql);
	pst.setString(1, user);
	ResultSet rs = pst.executeQuery();
	User u = new User();
	if (rs.next()) {
	    if (MD5Encrypter.encryptMD5(senha).equals(rs.getString("senha"))) {
		u.setId(rs.getInt("id"));
		u.setLogin(rs.getString("login"));
		u.setNome(rs.getString("nome"));
		pDB.connect();
		u.setPerfil(pDB.selectById(rs.getInt("id_perfil")));
		pDB.disconnect();
	    }
	}

	return u;
    }
    
    /*Edit a User object on the database*/
    public void update(User u) throws SQLException {

	PreparedStatement pst;
	String sql = "UPDATE usuario SET login=?, senha=?, id_perfil=?, nome=?  WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setString(1, u.getLogin());
	pst.setString(2, u.getSenha());
	pst.setInt(3, u.getPerfil().getId());
	pst.setString(4, u.getNome());
	pst.setInt(5, u.getId());
	pst.execute();

    }
    
    /*Load a User object with the id argument on the database*/
    public User selectById(int id) throws SQLException, Exception {
	User u = new User();
	ProfileDAO pDB = new ProfileDAO();
	PreparedStatement pst;
	String sql = "SELECT * FROM usuario WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, id);
	ResultSet rs = pst.executeQuery();
	if (rs.next()) {
	    u.setId(rs.getInt("id"));
	    u.setLogin(rs.getString("login"));
	    u.setSenha(rs.getString("senha"));
	    u.setNome(rs.getString("nome"));
	    pDB.connect();
	    u.setPerfil(pDB.selectById(rs.getInt("id_perfil")));
	    pDB.disconnect();
	}
	return u;

    }
    
    /*Delete a User object on the database*/
    public void delete(User u) throws SQLException {

	PreparedStatement pst;
	String sql = "DELETE FROM usuario WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, u.getId());
	pst.execute();

    }

}
