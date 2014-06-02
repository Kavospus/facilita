/*
 * Licensed under ..., see LICENSE.md
 * Authors:
 * Created on: May 30, 2014, 11:10:29 AM
 * Description:
 */

package model.test;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Calculus;
import modelo.CalculusDAO;
import modelo.Determine;
import modelo.Invert;
import modelo.MD5Encrypter;
import modelo.ProfileDAO;
import modelo.User;
import modelo.UserDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author gabriel
 */
public class CalculusTest {
    
    
    
    public CalculusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException, Exception {
        
        ProfileDAO profileDB = new ProfileDAO();
        profileDB.connect();
        User userTest = new User();
        userTest.setName("User Test");
        userTest.setLogin("test");
        userTest.setPassword("e10adc3949ba59abbe56e057f20f883e");
        userTest.setProfile(profileDB.selectById(1));
        
        profileDB.disconnect();
        UserDAO userDB = new UserDAO();
        userDB.connect();
        userDB.insert(userTest); 
        userTest = userDB.logon("test", "123456");
        userDB.disconnect();
                
        Invert invert = new Invert(new double[][]{{4,5},{4,5}},2,2);
        invert.setUser(userTest);
   
        
        invert.calculate();
        CalculusDAO calculusDB = new CalculusDAO();
        calculusDB.connect();
        calculusDB.insert(invert);
        
        Determine determine = new Determine(new double[][]{{4,5},{4,5}},2,2);
        determine.setUser(userTest);
        determine.calculate();
        
        calculusDB.insert(determine);
        calculusDB.disconnect();
    }
    
    @AfterClass
    public static void tearDownClass() throws SQLException, Exception {
        UserDAO userDB = new UserDAO();
        userDB.connect();
        User userTest = userDB.logon("test", "123456");
    
        CalculusDAO calculusDB = new CalculusDAO();
        calculusDB.connect();
        ArrayList<Calculus> calculus =  calculusDB.select(userTest);
        
        for(Calculus c:calculus){
            calculusDB.delete(c);
        }
        calculusDB.disconnect();
        userDB.delete(userTest);
        userDB.disconnect();
     }
    
    @Before
    public void setUp() throws Exception {
        
     
    }
    
    @After
    public void tearDown() throws Exception {
     
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void shouldInsertANewCalculus() throws Exception {
        UserDAO userDB = new UserDAO();
        userDB.connect();
        User userTest = userDB.logon("test", "123456");
        userDB.disconnect();
        Invert invert = new Invert(new double[][]{{4,5},{4,5}},2,2);
        invert.setUser(userTest);
       invert.calculate();
        
        CalculusDAO calculusDB = new CalculusDAO();
        calculusDB.connect();
        int calculusAmount = calculusDB.select(userTest).size();
        calculusDB.insert(invert);
        ArrayList<Calculus> calculus =  calculusDB.select(userTest);
        
        assertEquals(calculusAmount+1,calculus.size());
    
        
        calculusDB.delete(calculus.get(calculus.size()-1));
        
        calculusDB.disconnect();
    }
    @Test
    public void shouldSelectACalculusOnDataBase() throws Exception{
        UserDAO userDB = new UserDAO();
        userDB.connect();
        User userTest = userDB.logon("test", "123456");
        userDB.disconnect();
        
        CalculusDAO calculusDB = new CalculusDAO();
        calculusDB.connect();
        ArrayList<Calculus> calculusUser =calculusDB.select(userTest);
        
        assertEquals(calculusUser.size(), 2);
        
        calculusDB.disconnect();   
    }
    @Test
    public void shouldUpdateACalculusOnDataBase() throws Exception{
        UserDAO userDB = new UserDAO();
        userDB.connect();
        User userTest = userDB.logon("test", "123456");
        userDB.disconnect();
        
        Invert invert = new Invert(new double[][]{{4,5},{4,5}},2,2);
        invert.setUser(userTest);
        invert.calculate();
        
        
        CalculusDAO calculusDB = new CalculusDAO();
        calculusDB.connect();
        calculusDB.insert(invert);
        
            
        ArrayList<Calculus> calculus = calculusDB.select(userTest);
        Calculus c = calculus.get(calculus.size()-1); 
        c.setInputString("{{4,5,2},{4,5,2},{4,5,2}}");
       
        calculusDB.update(c);
        
        calculus = calculusDB.select(userTest);
        
        assertEquals("{{4,5,2},{4,5,2},{4,5,2}}", (calculus.get(calculus.size()-1)).getInputString());
        
        calculusDB.delete(calculus.get(calculus.size()-1));
        calculusDB.disconnect();   
    }
    
    @Test
    public void shouldDeleteACalculusOnDataBase() throws Exception{
        
        UserDAO userDB = new UserDAO();
        userDB.connect();
        User userTest = userDB.logon("test", "123456");
        userDB.disconnect();
        
        Invert invert = new Invert(new double[][] {{2,2},{2,2}},2,2);
        invert.setUser(userTest);
        invert.calculate();
        
        CalculusDAO calculusDB = new CalculusDAO();
        calculusDB.connect();
        int calculusAmount = calculusDB.select(userTest).size();
        calculusDB.insert(invert);
        ArrayList<Calculus> calculus =  calculusDB.select(userTest);
        
        assertEquals(calculusAmount+1,calculus.size());
        
        calculusDB.delete(calculus.get(calculus.size()-1));
        
        calculus = calculusDB.select(userTest);
        
        assertEquals(calculusAmount, calculus.size()); 
    }
    @Test
    public void shouldSelectACalculusByIdOnDataBase() throws Exception{
        
        UserDAO userDB = new UserDAO();
        userDB.connect();
        User userTest = userDB.logon("test", "123456");
        userDB.disconnect();
        
        CalculusDAO calculusDB = new CalculusDAO();
        calculusDB.connect();
        ArrayList<Calculus> calculus = calculusDB.select(userTest);
        
        Calculus c = calculus.get(calculus.size()-1);
        
        assertEquals(calculusDB.selectById(c.getId()).getId(), c.getId());
        
        calculusDB.disconnect();
    }
}
