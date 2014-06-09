/*
 * Licensed under ..., see LICENSE.md
 * Authors:
 * Created on: 06/06/2014, 10:21:28
 * Description:
 */

package model.test;

import java.util.ArrayList;
import modelo.Menu;
import modelo.MenuDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrebsguedes
 */
public class MenuTest {
    
    public MenuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        MenuDAO menuDB = new MenuDAO();
        Menu m = new Menu(0, "Test", "/test/test.jsp", "/images/test.png");
        menuDB.connect();
        menuDB.insert(m);
        menuDB.disconnect();
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        MenuDAO menuDB = new MenuDAO();
        menuDB.connect();
        ArrayList<Menu> menus = menuDB.select();
        menuDB.delete(menus.get(menus.size()-1));
        menuDB.disconnect();
    }
    
    @Before
    public void setUp() throws Exception {
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void shouldCreateANewMenu() throws Exception {
        MenuDAO menuDB = new MenuDAO();
        Menu m = new Menu(0, "Test", "/test/test.jsp", "/images/test.png");
        menuDB.connect();
        menuDB.insert(m);
        ArrayList<Menu> menus = menuDB.select();
        assertEquals("Test", menus.get(menus.size()-1).getMenu());
        menuDB.delete(menus.get(menus.size()-1));
        menuDB.disconnect();
    }
    
    public void shouldSelectAllMenus() throws Exception {
        MenuDAO menuDB = new MenuDAO();
        menuDB.connect();
        ArrayList<Menu> menus = menuDB.select();
        int amountMenus = menus.size();
        Menu m = new Menu(0, "Tests", "/test/test.jsp", "/images/test.png");
        menuDB.insert(m);
        assertEquals(amountMenus, menus.size());
        menuDB.delete(menus.get(menus.size()-1));
        menuDB.disconnect();
    }
    public void shouldSelectMenuById() throws Exception {
        MenuDAO menuDB = new MenuDAO();
        menuDB.connect();
        ArrayList<Menu> menus = menuDB.select();
        Menu menu = menuDB.selectById(menus.get(menus.size()-1).getId());
        assertEquals(menu.getMenu(), menus.get(menus.size()-1).getMenu());
        menuDB.disconnect();
    }
}
