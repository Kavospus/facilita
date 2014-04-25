/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: Database persistence class for Menu. That includes operations
 *list,update,remove,insert into database.
 */


package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuDAO extends DataBaseDAO {

    public MenuDAO() throws Exception {
    }
    
    /*Insert a Menu object to the database*/
    public void insert(Menu menu) throws SQLException{

        PreparedStatement preparedStatement;
        String sql = "INSERT INTO menu (menu,link,icone) values(?,?,?)";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,menu.getMenu());
        preparedStatement.setString(2, menu.getLink());
        preparedStatement.setString(3, menu.getIcon());
        preparedStatement.execute();

    }
    
    /*Consult a list of all Menu objects on the database*/
    public ArrayList<Menu> select() throws SQLException{

        ArrayList<Menu> lista = new ArrayList<Menu>();
        PreparedStatement preparedStatement;
        String sql = "SELECT * FROM menu";
        preparedStatement = conn.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
            Menu menu = new Menu(rs.getInt("id"),rs.getString("menu"),rs.getString("link"),rs.getString("icon"));
            lista.add(menu);
        }
        return lista;

    }
    
    /*
     *Consult a list of Menu objects associated by id_perfil argument
     *on the database
     */
    public ArrayList<Menu> menusPerfil(int id_perfil) throws SQLException {

        ArrayList<Menu> lista = new ArrayList<Menu>();
        PreparedStatement preparedStatement;
        String sql = "SELECT menu.* FROM menu as menu, "
                + "menu_perfil as mp "
                + "WHERE mp.id_perfil=? "
                + "AND mp.id_menu = menu.id";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,id_perfil);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
            Menu menu = new Menu(rs.getInt("id"),rs.getString("menu"),rs.getString("link"),rs.getString("icon"));
            lista.add(menu);
        }
        return lista;

    }
    
    /*
     *Consult a list of Menu objects not associated by id_perfil argument
     *on the database
     */
    public ArrayList<Menu> menusNaoPerfil(int id_perfil) throws SQLException {

        ArrayList<Menu> lista = new ArrayList<Menu>();
        PreparedStatement preparedStatement;
        String sql = "SELECT * FROM menu as menu WHERE id NOT IN(SELECT id_menu FROM menu_perfil WHERE id_perfil=?)";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,id_perfil);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
            Menu menu = new Menu(rs.getInt("id"),rs.getString("menu"),rs.getString("link"),rs.getString("icon"));
            lista.add(menu);
        }
        return lista;

    }
    
    /*Edit a Menu object on the database*/
    public void update(Menu menu) throws SQLException{

        PreparedStatement preparedStatement;
        String sql ="UPDATE menu SET menu=?, link=?, icone=?  WHERE id=?";
        preparedStatement =conn.prepareStatement(sql);
        preparedStatement.setString(1,menu.getMenu());
        preparedStatement.setString(2,menu.getLink());
        preparedStatement.setString(3,menu.getIcon());
        preparedStatement.setInt(4,menu.getId());
        preparedStatement.execute();

    }
    
    /*Load a Menu object with the id argument on the database*/
    public Menu selectById(int id) throws SQLException{
        Menu menu = new Menu();
        PreparedStatement preparedStatement;
        String sql ="SELECT * FROM menu WHERE id=?";
        preparedStatement =conn.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()){
        menu.setId(rs.getInt("id"));
        menu.setMenu(rs.getString("menu"));
        menu.setLink(rs.getString("link"));
        menu.setIcon(rs.getString("icon"));
        }
        return menu;

    }
    
    /*Delete a Menu object on the database*/
    public void delete(Menu menu) throws SQLException{

        PreparedStatement preparedStatement;
        String sql ="DELETE FROM menu WHERE id=?";
        preparedStatement =conn.prepareStatement(sql);
        preparedStatement.setInt(1,menu.getId());
        preparedStatement.execute();

    }
    
    /*
     *Associate a Menu object with a Profile object 
     *throught id_menu and id_profile arguments on the database
     */
    public void vincularMenu(int id_menu, int id_perfil) throws SQLException{

        PreparedStatement preparedStatement;
        String sql = "INSERT INTO menu_perfil (id_menu,id_perfil) values(?,?)";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,id_menu);
        preparedStatement.setInt(2,id_perfil);
        preparedStatement.execute();

    }
    
    /*
     *Disassociate a Menu object with a Profile object 
     *throught id_menu and id_profile arguments on the database
     */
    public void desvincularMenu(int id_menu, int id_perfil) throws SQLException{

        PreparedStatement preparedStatement;
        String sql = "DELETE FROM menu_perfil WHERE id_menu=? AND id_perfil=?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,id_menu);
        preparedStatement.setInt(2,id_perfil);
        preparedStatement.execute();

    }

}
