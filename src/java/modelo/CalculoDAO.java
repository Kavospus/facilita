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
    
    public Calculo init(String operador) {
	Calculo calculo = null;
	if (operador.equals("Inverter")) {
	    calculo = new Inverter();
	} else if (operador.equals("Transpor")) {
	    calculo = new Transpor();
	} else if (operador.equals("Determinar")) {
	    calculo = new Determinar();
	} else if (operador.equals("Somar")) {
	    calculo = new Somar();
	} else if (operador.equals("Subtrair")) {
	    calculo = new Subtrair();
	} else if (operador.equals("Multiplicar")) {
	    calculo = new Multiplicar();
	} else if (operador.equals("Escalar")) {
	    calculo = new Escalar();
	}

	return calculo;
    }
    
    public void inserir(Calculo c) throws SQLException {

	PreparedStatement pst;
	String sql = "INSERT INTO calculo (id_usuario,operacao,entrada,resultado) values(?,?,?,?)";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, c.getUsuario().getId());
	pst.setString(2, c.getOperacao());
	pst.setString(3, c.getStringEntrada());
	pst.setString(4, c.getStringResultado());
	pst.execute();

    }

    public ArrayList<Calculo> listar() throws SQLException, Exception {

	UsuarioDAO uDB = new UsuarioDAO();
	ArrayList<Calculo> lista = new ArrayList<Calculo>();
	PreparedStatement pst;
	String sql = "SELECT * FROM calculo";
	pst = conn.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();
	while (rs.next()) {
	    Calculo c = init(rs.getString("operacao"));
	    c.setId(rs.getInt("id"));
	    c.setOperacao(rs.getString("operacao"));
	    c.setStringEntrada(rs.getString("entrada"));
	    c.setStringResultado(rs.getString("resultado"));
	    uDB.conectar();
	    c.setUsuario(uDB.carregaPorId(rs.getInt("id_usuario")));
	    uDB.desconectar();
	    lista.add(c);
	}
	return lista;

    }

    public ArrayList<Calculo> listar(Usuario u) throws SQLException, Exception {
        UsuarioDAO uDB = new UsuarioDAO();
	ArrayList<Calculo> lista = new ArrayList<Calculo>();
	PreparedStatement pst;
	String sql = "SELECT * FROM calculo WHERE id_usuario=?";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, u.getId());
	ResultSet rs = pst.executeQuery();
	while (rs.next()) {
	    Calculo c = init(rs.getString("operacao"));
	    c.setId(rs.getInt("id"));
	    c.setOperacao(rs.getString("operacao"));
	    c.setStringEntrada(rs.getString("entrada"));
	    c.setStringResultado(rs.getString("resultado"));
	    uDB.conectar();
	    c.setUsuario(uDB.carregaPorId(rs.getInt("id_usuario")));
	    uDB.desconectar();
	    lista.add(c);
	}
	return lista;

    }

    public void alterar(Calculo c) throws SQLException {
	PreparedStatement pst;
	String sql = "UPDATE calculo SET operacao=?, entrada=?, resultado=?, id_usuario=?  WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setString(1, c.getOperacao());
	pst.setString(2, c.getStringEntrada());
	pst.setString(3, c.getStringResultado());
	pst.setInt(4, c.getUsuario().getId());
	pst.setInt(5, c.getId());
	pst.execute();

    }

    public Calculo carregaPorId(int id) throws SQLException, Exception {
	UsuarioDAO uDB = new UsuarioDAO();
	PreparedStatement pst;
	String sql = "SELECT * FROM calculo WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, id);
	ResultSet rs = pst.executeQuery();
	if (rs.next()) {
	    Calculo c = init(rs.getString("operacao"));
	    c.setId(rs.getInt("id"));
	    c.setOperacao(rs.getString("operacao"));
	    c.setStringEntrada(rs.getString("entrada"));
	    c.setStringResultado(rs.getString("resultado"));
	    uDB.conectar();
	    c.setUsuario(uDB.carregaPorId(rs.getInt("id_usuario")));
	    uDB.desconectar();
	    return c;
	}
	return null;

    }

    public void excluir(Calculo c) throws SQLException {
	PreparedStatement pst;
	String sql = "DELETE FROM calculo WHERE id=?";
	pst = conn.prepareStatement(sql);
	pst.setInt(1, c.getId());
	pst.execute();

    }

}
