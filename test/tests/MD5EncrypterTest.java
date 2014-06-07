/*
 * Licensed under ..., see LICENSE.md
 * Authors:
 * Created on: 07/06/2014, 09:38:48
 * Description:
 */

package tests;

import modelo.MD5Encrypter;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author luis
 */
public class MD5EncrypterTest {
    
    public MD5EncrypterTest() {
    }

    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testMD5EncrypterFirstString(){
        testMD5Encrypter("admin","21232f297a57a5a743894a0e4a801fc3");
    }
    
    @Test
    public void testMD5EncrypterSecondString(){
        testMD5Encrypter("guest","084e0343a0486ff05530df6c705c8bb4");
    }
    
    @Test
    public void testMD5EncrypterThirdString(){
        testMD5Encrypter("123456","e10adc3949ba59abbe56e057f20f883e");
    }
    
    private void testMD5Encrypter(String literalPassword, String encrypterPassword) {
        String resultPassword; 
        resultPassword = MD5Encrypter.encryptMD5(literalPassword);
        assertEquals(resultPassword,encrypterPassword);
    }
}
