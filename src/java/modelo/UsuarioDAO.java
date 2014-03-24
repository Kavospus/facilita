package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO extends DataBaseDAO {

    public UsuarioDAO() throws Exception {
    }

    public void inserir(Usuario u) throws SQLException{

        PreparedStatement pst;
        String sql = "INSERT INTO usuario (id_perfil,login,senha,nome) values(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setInt(1,u.getPerfil().getId());
        pst.setString(2, u.getLogin());
        pst.setString(3, u.getSenha());
        pst.setString(4, u.getNome());
        pst.execute();

    }

    public ArrayList<Usuario> listar() throws SQLException, Exception{
        
        PerfilDAO pDB =new PerfilDAO();
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        PreparedStatement pst;
        String sql = "SELECT * FROM usuario";
        pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setNome(rs.getString("nome"));
                pDB.conectar();
                u.setPerfil(pDB.carregaPorId(rs.getInt("id_perfil")));
                pDB.desconectar();
            lista.add(u);
        }
        return lista;

    }

    public Usuario logar(String user,String senha) throws SQLException,Exception {
        PerfilDAO pDB =new PerfilDAO();
        PreparedStatement pst;
        String sql = "SELECT * FROM usuario WHERE login=?";
        pst=conn.prepareStatement(sql);
        pst.setString(1,user);
        ResultSet rs = pst.executeQuery();
        Usuario u = new Usuario();
        if(rs.next()){
            if(MD5Encrypter.encryptMD5(senha).equals(rs.getString("senha"))){
                u.setId(rs.getInt("id"));
                u.setLogin(rs.getString("login"));
                u.setNome(rs.getString("nome"));
                pDB.conectar();
                u.setPerfil(pDB.carregaPorId(rs.getInt("id_perfil")));
                pDB.desconectar();
            }
        }


        return u;
    }

    public void alterar(Usuario u) throws SQLException{

        PreparedStatement pst;
        String sql ="UPDATE usuario SET login=?, senha=?, id_perfil=?, nome=?  WHERE id=?";
        pst =conn.prepareStatement(sql);
        pst.setString(1, u.getLogin());
        pst.setString(2, u.getSenha());
        pst.setInt(3, u.getPerfil().getId());
        pst.setString(4, u.getNome());
        pst.setInt(5,u.getId());
        pst.execute();

    }


        public Usuario carregaPorId(int id) throws SQLException, Exception{
        Usuario u = new Usuario();
        PerfilDAO pDB = new PerfilDAO();
        PreparedStatement pst;
        String sql ="SELECT * FROM usuario WHERE id=?";
        pst =conn.prepareStatement(sql);
        pst.setInt(1,id);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
        u.setId(rs.getInt("id"));
        u.setLogin(rs.getString("login"));
        u.setSenha(rs.getString("senha"));
        u.setNome(rs.getString("nome"));
        pDB.conectar();
        u.setPerfil(pDB.carregaPorId(rs.getInt("id_perfil")));
        pDB.desconectar();
        }
        return u;

    }

    public void excluir(Usuario u) throws SQLException{

        PreparedStatement pst;
        String sql ="DELETE FROM usuario WHERE id=?";
        pst =conn.prepareStatement(sql);
        pst.setInt(1,u.getId());
        pst.execute();

    }



    
}


