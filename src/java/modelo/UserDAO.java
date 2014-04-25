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
    public void insert(User user) throws SQLException {

	PreparedStatement preparedStatement;
	String sql = "INSERT INTO usuario (id_perfil,login,senha,nome) "
		+ "values(?,?,?,?)";
	preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setInt(1, user.getPerfil().getId());
	preparedStatement.setString(2, user.getLogin());
	preparedStatement.setString(3, user.getSenha());
	preparedStatement.setString(4, user.getNome());
	preparedStatement.execute();

    }
    
    /*Consult a list of all User objects on the database*/
    public ArrayList<User> select() throws SQLException, Exception {

	ProfileDAO profileDB = new ProfileDAO();
	ArrayList<User> lista = new ArrayList<User>();
	PreparedStatement preparedStatement;
	String sql = "SELECT * FROM usuario";
	preparedStatement = conn.prepareStatement(sql);
	ResultSet rs = preparedStatement.executeQuery();
	while (rs.next()) {
	    User user = new User();
	    user.setId(rs.getInt("id"));
	    user.setLogin(rs.getString("login"));
	    user.setSenha(rs.getString("senha"));
	    user.setNome(rs.getString("nome"));
	    profileDB.connect();
	    user.setPerfil(profileDB.selectById(rs.getInt("id_perfil")));
	    profileDB.disconnect();
	    lista.add(user);
	}
	return lista;

    }
    
    /*Login a User object throught the user and password arguments*/
    public User logon(String login, String senha) throws SQLException,
	    Exception {
	ProfileDAO profileDB = new ProfileDAO();
	PreparedStatement preparedStatement;
	String sql = "SELECT * FROM usuario WHERE login=?";
	preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setString(1, login);
	ResultSet rs = preparedStatement.executeQuery();
	User user = new User();
	if (rs.next()) {
	    if (MD5Encrypter.encryptMD5(senha).equals(rs.getString("senha"))) {
		user.setId(rs.getInt("id"));
		user.setLogin(rs.getString("login"));
		user.setNome(rs.getString("nome"));
		profileDB.connect();
		user.setPerfil(profileDB.selectById(rs.getInt("id_perfil")));
		profileDB.disconnect();
	    }
	}

	return user;
    }
    
    /*Edit a User object on the database*/
    public void update(User user) throws SQLException {

	PreparedStatement preparedStatement;
	String sql = "UPDATE usuario SET login=?, senha=?, id_perfil=?, nome=?  WHERE id=?";
	preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setString(1, user.getLogin());
	preparedStatement.setString(2, user.getSenha());
	preparedStatement.setInt(3, user.getPerfil().getId());
	preparedStatement.setString(4, user.getNome());
	preparedStatement.setInt(5, user.getId());
	preparedStatement.execute();

    }
    
    /*Load a User object with the id argument on the database*/
    public User selectById(int id) throws SQLException, Exception {
	User user = new User();
	ProfileDAO profileDB = new ProfileDAO();
	PreparedStatement preparedStatement;
	String sql = "SELECT * FROM usuario WHERE id=?";
	preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setInt(1, id);
	ResultSet rs = preparedStatement.executeQuery();
	if (rs.next()) {
	    user.setId(rs.getInt("id"));
	    user.setLogin(rs.getString("login"));
	    user.setSenha(rs.getString("senha"));
	    user.setNome(rs.getString("nome"));
	    profileDB.connect();
	    user.setPerfil(profileDB.selectById(rs.getInt("id_perfil")));
	    profileDB.disconnect();
	}
	return user;

    }
    
    /*Delete a User object on the database*/
    public void delete(User user) throws SQLException {

	PreparedStatement preparedStatement;
	String sql = "DELETE FROM usuario WHERE id=?";
	preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setInt(1, user.getId());
	preparedStatement.execute();

    }

}
