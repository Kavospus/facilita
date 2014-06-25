/*
 * Licensed under ..., see LICENSE.md
 * Authors:
 * Created on: Jun 10, 2014, 10:46:31 PM
 * Description:
 */

package model.test;

import java.util.ArrayList;
import modelo.Menu;
import modelo.MenuDAO;
import modelo.Profile;
import modelo.ProfileDAO;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author gabriel
 */
public class ProfileTest {
    
    public ProfileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
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
     public void shouldInsertANewProfileOnDatabase() throws Exception {
         Profile profileTest = new Profile();
         profileTest.setProfile("Test");
         
         MenuDAO menuDB = new MenuDAO();
         ArrayList<Menu> menuTest = new ArrayList<Menu>();
         menuTest = menuDB.select();
         
         profileTest.setMenus(menuTest);
         
         ProfileDAO profileDB = new ProfileDAO();
         profileDB.connect();
         
         ArrayList<Profile> currentProfiles = new ArrayList<Profile>();
         currentProfiles = profileDB.select();
         int profileAmount = currentProfiles.size();
         
         profileDB.insert(profileTest);
         
         assertEquals(profileDB.select().size(),profileAmount+1);
         
         currentProfiles = profileDB.select();
         
         assertEquals(currentProfiles.get(currentProfiles.size()-1).getProfile(),
                 profileTest.getProfile());
         
         profileDB.delete(currentProfiles.get(currentProfiles.size() -1));
         profileDB.disconnect();         
     }
}
