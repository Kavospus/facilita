/*
 * Licensed under ..., see LICENSE.md
 * Authors:
 * Created on: Jun 2, 2014, 11:23:12 AM
 * Description:
 */

package model.test;

import java.util.ArrayList;
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
public class UserDAOTest {
    
    public UserDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
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
        userDB.disconnect();
        
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        UserDAO userDB = new UserDAO();
        userDB.connect();
        
        User userTest = new User();
        userTest = userDB.logon("test", "123456");
        userDB.delete(userTest);
        userDB.disconnect();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
     @Test
     public void shouldInsertANewUserOnDataBase() throws Exception{
           ProfileDAO profileDB = new ProfileDAO();
        profileDB.connect();
        User userTest = new User();
        userTest.setName("User Test");
        userTest.setLogin("newTest");
        userTest.setPassword("e10adc3949ba59abbe56e057f20f883e");
        userTest.setProfile(profileDB.selectById(1));
        
        profileDB.disconnect();
        UserDAO userDB = new UserDAO();
        userDB.connect();
        userDB.insert(userTest); 
     
        userTest = userDB.logon("newTest", "123456");
        
         assertEquals(userDB.selectById(userTest.getId()).getId(),userTest.getId());
       
         userDB.delete(userTest);
         
         userDB.disconnect();  
     }
     
     @Test
     public void shouldSelectAllUserOnDataBase() throws Exception{
         UserDAO userDB = new UserDAO(); 
         userDB.connect();
         
         ArrayList<User> users = new ArrayList<User>();
         
         users = userDB.select();
         
         assertTrue(users.size()>=1);
         
         assertEquals("test",users.get(users.size()-1).getLogin());
         userDB.disconnect();
     }
     
     @Test
     public void shouldUpdateAUserOnDataBase() throws Exception{  
        ProfileDAO profileDB = new ProfileDAO();
        profileDB.connect();
        User userTest = new User();
        userTest.setName("User Test");
        userTest.setLogin("newTestToUpdate");
        userTest.setPassword("e10adc3949ba59abbe56e057f20f883e");
        userTest.setProfile(profileDB.selectById(1));
        profileDB.disconnect();
      
        UserDAO userDB = new UserDAO();
        userDB.connect();
        userDB.insert(userTest);
       
        userTest = userDB.logon("newTestToUpdate", "123456");
        assertEquals(userDB.selectById(userTest.getId()).getLogin(),userTest.getLogin());
        
        userTest.setLogin("newTestUpdated");
        userTest.setName("User Test");
        userTest.setPassword("e10adc3949ba59abbe56e057f20f883e");
        
        userDB.update(userTest);
 
        userTest = userDB.logon("newTestUpdated", "123456");
        assertEquals(userDB.selectById(userTest.getId()).getLogin(),userTest.getLogin());
        
        userDB.delete(userTest);
        userDB.disconnect();
     }
     
     @Test
     public void shouldDeleteAUserOnDataBase() throws Exception{
        ProfileDAO profileDB = new ProfileDAO();
        profileDB.connect();
        User userTest = new User();
        userTest.setName("User Test");
        userTest.setLogin("userTestToDelete");
        userTest.setPassword("e10adc3949ba59abbe56e057f20f883e");
        userTest.setProfile(profileDB.selectById(1));
        profileDB.disconnect();
      
        UserDAO userDB = new UserDAO();
        userDB.connect();
        userDB.insert(userTest);
        
        int userAmount = userDB.select().size();
        
        userTest = userDB.logon("userTestToDelete","123456");
        userDB.delete(userTest);
        
         assertEquals(userDB.select().size(), userAmount-1);
        
         userDB.disconnect();
     }
     
     @Test
     public void shouldSelectAUserById() throws Exception{
        UserDAO userDB = new UserDAO(); 
        userDB.connect();
        
        ArrayList<User> allUsers = new ArrayList<User>();
        
        allUsers = userDB.select();
        
        User userTest = allUsers.get(allUsers.size()-1);
        
         assertEquals(userDB.selectById(userTest.getId()).getId(), userTest.getId());
        
         userDB.disconnect();
     }
}
