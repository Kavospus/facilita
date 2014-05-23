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
    /**
     *
     * @param userToInsert 
     * @throws SQLException
     * Insert a User object to the database*/
    public void insert(User userToInsert) throws SQLException {

	PreparedStatement pst;
	String sql = "INSERT INTO usuario (id_perfil,login,senha,nome) "
		+ "values(?,?,?,?)";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, userToInsert.getProfile().getId());
	pst.setString(2, userToInsert.getLogin());
	pst.setString(3, userToInsert.getPassword());
	pst.setString(4, userToInsert.getName());
	pst.execute();

    }
    /**
     *
     * @throws SQLException
     * @throws Exception
     * @return  lista
     * Consult a list of all User objects on the database*/
    public ArrayList<User> select() throws SQLException, Exception {

	ProfileDAO pDB = new ProfileDAO();
	ArrayList<User> lista = new ArrayList<User>();
	PreparedStatement pst;
	String sql = "SELECT * FROM usuario";
	pst = conn.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
	while (rs.next()) {
	    User newUser = new User();
	    newUser.setId(rs.getInt("id"));
	    newUser.setLogin(rs.getString("login"));
	    newUser.setPassword(rs.getString("senha"));
	    newUser.setName(rs.getString("nome"));
	    pDB.connect();
	    newUser.setProfile(pDB.selectById(rs.getInt("id_perfil")));
	    pDB.disconnect();
	    lista.add(newUser);
	}
	return lista;

    }
    /**
     *
     * @param user
     * @param senha
     * @throws SQLException
     * @return  newUser;
 Login a User object throught the user and password arguments*/
    public User logon(String user, String senha) throws SQLException,
	    Exception {
	ProfileDAO pDB = new ProfileDAO();
	PreparedStatement pst;
	String sql = "SELECT * FROM usuario WHERE login=?";
	pst = conn.prepareStatement(sql);
	pst.setString(1, user);
	ResultSet rs = pst.executeQuery();
	User userToLogon = new User();
	if (rs.next()) {
	    if (MD5Encrypter.encryptMD5(senha).equals(rs.getString("senha"))) {
		userToLogon.setId(rs.getInt("id"));
		userToLogon.setLogin(rs.getString("login"));
		userToLogon.setName(rs.getString("nome"));
		pDB.connect();
		userToLogon.setProfile(pDB.selectById(rs.getInt("id_perfil")));
		pDB.disconnect();
	    }
            else{
                //Nothing to do
            }
	}
        else{
            //Nothing to do
        }

	return userToLogon;
    }
    /**
     *
     * @param userToUpdate 
     * @throws SQLException
     * Edit a User object on the database*/
    public void update(User userToUpdate) throws SQLException {

	PreparedStatement pst;
	String sql = "UPDATE usuario SET login=?, senha=?, id_perfil=?, nome=?  WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setString(1, userToUpdate.getLogin());
	pst.setString(2, userToUpdate.getPassword());
	pst.setInt(3, userToUpdate.getProfile().getId());
	pst.setString(4, userToUpdate.getName());
	pst.setInt(5, userToUpdate.getId());
	pst.execute();

    }
    /**
     *
     * @param id 
     * @throws SQLException
     * @throws Exception
     * @return newUser
 Load a User object with the id argument on the database*/
    public User selectById(int id) throws SQLException, Exception {
	User userToSelect = new User();
	ProfileDAO pDB = new ProfileDAO();
	PreparedStatement pst;
	String sql = "SELECT * FROM usuario WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, id);
	ResultSet rs = pst.executeQuery();
	if (rs.next()) {
	    userToSelect.setId(rs.getInt("id"));
	    userToSelect.setLogin(rs.getString("login"));
	    userToSelect.setPassword(rs.getString("senha"));
	    userToSelect.setName(rs.getString("nome"));
	    pDB.connect();
	    userToSelect.setProfile(pDB.selectById(rs.getInt("id_perfil")));
	    pDB.disconnect();
	}
        else{
            //Nothing to do
        }
	return userToSelect;

    }
    /**
     *
     * @param userToDelete 
     * @throws SQLException
     * Delete a User object on the database*/
    public void delete(User userToDelete) throws SQLException {

	PreparedStatement pst;
	String sql = "DELETE FROM usuario WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, userToDelete.getId());
	pst.execute();

    }

}
