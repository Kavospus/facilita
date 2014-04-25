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

public class CalculoDAO extends DataBaseDAO {

    public CalculoDAO() throws Exception {
    }
    /*Initialize Calculos object acording to the operator*/
    public Calculus init(String operador) {
	Calculus calculo = null;
	if (operador.equals("Invert")) {
	    calculo = new Invert();
	} else if (operador.equals("Transpose")) {
	    calculo = new Transpose();
	} else if (operador.equals("Determine")) {
	    calculo = new Determine();
	} else if (operador.equals("Sum")) {
	    calculo = new Sum();
	} else if (operador.equals("Subtrair")) {
	    calculo = new Subtrair();
	} else if (operador.equals("Multiplicar")) {
	    calculo = new Multiplicar();
	} else if (operador.equals("Scale")) {
	    calculo = new Scale();
	}

	return calculo;
    }   
    
    /*Insert a Calculus object to the database*/
    public void insert(Calculus c) throws SQLException {

	PreparedStatement pst;
	String sql = "INSERT INTO calculo (id_usuario,operacao,entrada,resultado) values(?,?,?,?)";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, c.getUser().getId());
	pst.setString(2, c.getOperation());
	pst.setString(3, c.getInputString());
	pst.setString(4, c.getResultString());
	pst.execute();

    }
    
    /*Consult a list of all Calculus objects on the database*/
    public ArrayList<Calculus> select() throws SQLException, Exception {

	UsuarioDAO uDB = new UsuarioDAO();
	ArrayList<Calculus> lista = new ArrayList<Calculus>();
	PreparedStatement pst;
	String sql = "SELECT * FROM calculo";
	pst = conn.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
	while (rs.next()) {
	    Calculus c = init(rs.getString("operacao"));
	    c.setId(rs.getInt("id"));
	    c.setOperation(rs.getString("operacao"));
	    c.setInputString(rs.getString("entrada"));
	    c.setResultString(rs.getString("resultado"));
	    uDB.conectar();
	    c.setUser(uDB.selectById(rs.getInt("id_usuario")));
	    uDB.desconectar();
	    lista.add(c);
	}
	return lista;

    }
    
    /*Consult a list of Calculus objects owned by the User argument on the database*/
    public ArrayList<Calculus> select(User u) throws SQLException, Exception {
        UsuarioDAO uDB = new UsuarioDAO();
	ArrayList<Calculus> lista = new ArrayList<Calculus>();
	PreparedStatement pst;
	String sql = "SELECT * FROM calculo WHERE id_usuario=?";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, u.getId());
	ResultSet rs = pst.executeQuery();
	while (rs.next()) {
	    Calculus c = init(rs.getString("operacao"));
	    c.setId(rs.getInt("id"));
	    c.setOperation(rs.getString("operacao"));
	    c.setInputString(rs.getString("entrada"));
	    c.setResultString(rs.getString("resultado"));
	    uDB.conectar();
	    c.setUser(uDB.selectById(rs.getInt("id_usuario")));
	    uDB.desconectar();
	    lista.add(c);
	}
	return lista;

    }
    
    /*Edit a Calculus object on the database*/
    public void update(Calculus c) throws SQLException {
	PreparedStatement pst;
	String sql = "UPDATE calculo SET operacao=?, entrada=?, resultado=?, id_usuario=?  WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setString(1, c.getOperation());
	pst.setString(2, c.getInputString());
	pst.setString(3, c.getResultString());
	pst.setInt(4, c.getUser().getId());
	pst.setInt(5, c.getId());
	pst.execute();

    }
    /*Load a Calculus object with the id argument on the database*/
    public Calculus selectById(int id) throws SQLException, Exception {
	UsuarioDAO uDB = new UsuarioDAO();
	PreparedStatement pst;
	String sql = "SELECT * FROM calculo WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, id);
	ResultSet rs = pst.executeQuery();
	if (rs.next()) {
	    Calculus c = init(rs.getString("operacao"));
	    c.setId(rs.getInt("id"));
	    c.setOperation(rs.getString("operacao"));
	    c.setInputString(rs.getString("entrada"));
	    c.setResultString(rs.getString("resultado"));
	    uDB.conectar();
	    c.setUser(uDB.selectById(rs.getInt("id_usuario")));
	    uDB.desconectar();
	    return c;
	}
	return null;

    }
    
    /*Delete a Calculus object on the database*/
    public void delete(Calculus c) throws SQLException {
	PreparedStatement pst;
	String sql = "DELETE FROM calculo WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, c.getId());
	pst.execute();

    }

}
