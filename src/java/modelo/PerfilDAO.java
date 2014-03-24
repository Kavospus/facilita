package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PerfilDAO extends DataBaseDAO{

    public PerfilDAO() throws Exception {
    }

    public void inserir(Perfil p) throws SQLException{

        PreparedStatement pst;
        String sql ="INSERT INTO perfil(perfil) VALUES(?)";
        pst =conn.prepareStatement(sql);
        pst.setString(1,p.getPerfil());
        pst.execute();

    }
    
    public ArrayList<Perfil> listar() throws SQLException, Exception{
        MenuDAO mDB = new MenuDAO();
        ArrayList<Perfil> lista = new ArrayList<Perfil>();
        PreparedStatement pst;
        String sql = "SELECT * FROM perfil";
        pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            mDB.conectar();
            Perfil p = new Perfil(rs.getInt("id"), rs.getString("perfil"),mDB.menusPerfil(rs.getInt("id")));
            mDB.desconectar();
            lista.add(p);
        }
        return lista;

    }

    public void excluir(Perfil p) throws SQLException{

        PreparedStatement pst;
        String sql ="DELETE FROM perfil WHERE id=?";
        pst =conn.prepareStatement(sql);
        pst.setInt(1,p.getId());
        pst.execute();

    }

    public Perfil carregaPorId(int id) throws SQLException, Exception{
        Perfil p = new Perfil();
        MenuDAO mDB = new MenuDAO();
        PreparedStatement pst;
        String sql ="SELECT * FROM perfil WHERE id=?";
        pst =conn.prepareStatement(sql);
        pst.setInt(1,id);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
        p.setId(rs.getInt("id"));
        p.setPerfil(rs.getString("perfil"));
        mDB.conectar();
        p.setMenus(mDB.menusPerfil(id));
        mDB.desconectar();
        }
        return p;

    }

    public void alterar(Perfil p) throws SQLException{

        PreparedStatement pst;
        String sql ="UPDATE perfil SET perfil=? WHERE id=?";
        pst =conn.prepareStatement(sql);
        pst.setString(1,p.getPerfil());
        pst.setInt(2,p.getId());
        pst.execute();

    }


}

