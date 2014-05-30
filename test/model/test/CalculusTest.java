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
        userTest.setPassword("123456");
        userTest.setProfile(profileDB.selectById(1));
        
        profileDB.disconnect();
        UserDAO userDB = new UserDAO();
        userDB.connect();
        userDB.insert(userTest);
        userDB.disconnect();
                
        Invert invert = new Invert();
        invert.setUser(userTest);
        invert.setColumnsA(2);
        invert.setLinesA(2);
        invert.setInput(new double[][]{{4,5},{4,5}});
        
        invert.calculate();
        CalculusDAO calculusDB = new CalculusDAO();
        calculusDB.connect();
        calculusDB.insert(invert);
        
        Determine determine = new Determine();
        determine.setUser(userTest);
        determine.setColumnsA(2);
        determine.setLinesA(2);
        determine.setInput(new double[][]{{4,5},{4,5}});
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
        Invert invert = new Invert();
        invert.setUser(userTest);
        invert.setColumnsA(2);
        invert.setLinesA(2);
        invert.setInput(new double[][]{{4,5},{4,5}});
        invert.calculate();
        
        CalculusDAO calculusDB = new CalculusDAO();
        calculusDB.connect();
        int calculusAmount = calculusDB.select(userTest).size();
        calculusDB.insert(invert);
        ArrayList<Calculus> calculus =  calculusDB.select(userTest);
        
        assertEquals(calculusAmount+1,calculus.size());
    
        for(Calculus c:calculus){
            calculusDB.delete(c);
        }
        calculusDB.disconnect();
    }
}
