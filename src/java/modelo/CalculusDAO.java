/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Database persistence class for Calculus. That includes operations
 *list,update,remove,insert into database.
 */

package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CalculusDAO extends DataBaseDAO {

    public CalculusDAO() throws Exception {
    }
    /**
     *
     * @param operador 
     * @return calculo
     * Initialize Calculos object acording to the operator*/
    public Calculus init(String operador) {
	
        Calculus calculo = null;
	
        if (operador.equals("Invert")) {
	    calculo = new Invert();
	} 
        else if (operador.equals("Transpose")) {
	    calculo = new Transpose();
	} 
        else if (operador.equals("Determine")) {
	    calculo = new Determine();
	} 
        else if (operador.equals("Sum")) {
	    calculo = new Sum();
	} 
        else if (operador.equals("Subtract")) {
	    calculo = new Subtract();
	} 
        else if (operador.equals("Multiply")) {
	    calculo = new Multiply();
	} 
        else if (operador.equals("Scale")) {
	    calculo = new Scale();
	}

	return calculo;
    }   
    /**
     *
     * @param calculus 
     * @throws SQLException
     * Insert a Calculus object to the database*/
    public void insert(Calculus calculus) throws SQLException {

	PreparedStatement preparedStatement;
	String sql = "INSERT INTO calculo (id_usuario,operacao,entrada,resultado) values(?,?,?,?)";
	preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setInt(1, calculus.getUser().getId());
	preparedStatement.setString(2, calculus.getOperation());
	preparedStatement.setString(3, calculus.getInputString());
	preparedStatement.setString(4, calculus.getResultString());
	preparedStatement.execute();

    }
    /**
     *
     * @throws SQLException
     * @throws Exception
     * @return lista
     * Consult a list of all Calculus objects on the database*/
    public ArrayList<Calculus> select() throws SQLException, Exception {

	UserDAO userDB = new UserDAO();
	ArrayList<Calculus> lista = new ArrayList<Calculus>();
	PreparedStatement preparedStatement;
	String sql = "SELECT * FROM calculo";
	preparedStatement = conn.prepareStatement(sql);
	ResultSet rs = preparedStatement.executeQuery();
	while (rs.next()) {
	    Calculus calculus = init(rs.getString("operacao"));
	    calculus.setId(rs.getInt("id"));
	    calculus.setOperation(rs.getString("operacao"));
	    calculus.setInputString(rs.getString("entrada"));
	    calculus.setResultString(rs.getString("resultado"));
	    userDB.connect();
	    calculus.setUser(userDB.selectById(rs.getInt("id_usuario")));
	    userDB.disconnect();
	    lista.add(calculus);
	}
	return lista;

    }
    /**
     *
     * @param user 
     * @throws SQLException
     * @throws Exception
     * @return lista
     * Consult a list of Calculus objects owned by the User argument on the database*/
    public ArrayList<Calculus> select(User user) throws SQLException, Exception {
        UserDAO userDB = new UserDAO();
	ArrayList<Calculus> lista = new ArrayList<Calculus>();
	PreparedStatement preparedStatement;
        
	String sql = "SELECT * FROM calculo WHERE id_usuario=?";
	preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setInt(1, user.getId());
	ResultSet rs = preparedStatement.executeQuery();
        
	while (rs.next()) {
	    Calculus calculus = init(rs.getString("operacao"));
            
	    calculus.setId(rs.getInt("id"));
	    calculus.setOperation(rs.getString("operacao"));
	    calculus.setInputString(rs.getString("entrada"));
	    calculus.setResultString(rs.getString("resultado"));
	    userDB.connect();
	    calculus.setUser(userDB.selectById(rs.getInt("id_usuario")));
	    userDB.disconnect();
	    lista.add(calculus);
	}
	return lista;

    }
    /**
     *
     * @param calculus 
     * @throws SQLException
     * Edit a Calculus object on the database*/
    public void update(Calculus calculus) throws SQLException {
	PreparedStatement preparedStatement;
	String sql = "UPDATE calculo SET operacao=?, entrada=?, resultado=?, id_usuario=?  WHERE id=?";
	preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setString(1, calculus.getOperation());
	preparedStatement.setString(2, calculus.getInputString());
	preparedStatement.setString(3, calculus.getResultString());
	preparedStatement.setInt(4, calculus.getUser().getId());
	preparedStatement.setInt(5, calculus.getId());
	preparedStatement.execute();

    }
    /**
     *
     * @param id 
     * @throws SQLException
     * @throws Exception
     * @return calculus
     * Load a Calculus object with the id argument on the database*/
    public Calculus selectById(int id) throws SQLException, Exception {
	UserDAO userDB = new UserDAO();
	PreparedStatement preparedStatement;
	String sql = "SELECT * FROM calculo WHERE id=?";
	preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setInt(1, id);
	ResultSet rs = preparedStatement.executeQuery();
	if (rs.next()) {
	    Calculus calculus = init(rs.getString("operacao"));
	    calculus.setId(rs.getInt("id"));
	    calculus.setOperation(rs.getString("operacao"));
	    calculus.setInputString(rs.getString("entrada"));
	    calculus.setResultString(rs.getString("resultado"));
	    userDB.connect();
	    calculus.setUser(userDB.selectById(rs.getInt("id_usuario")));
	    userDB.disconnect();
	    return calculus;
	}
        else{   
	    return null;
        }
    }
    /**
     *
     * @param calculus 
     * @throws SQLException
     * Delete a Calculus object on the database*/
    public void delete(Calculus calculus) throws SQLException {
	PreparedStatement preparedStatement;
	String sql = "DELETE FROM calculo WHERE id=?";
	preparedStatement = conn.prepareStatement(sql);
	preparedStatement.setInt(1, calculus.getId());
	preparedStatement.execute();

    }

}
