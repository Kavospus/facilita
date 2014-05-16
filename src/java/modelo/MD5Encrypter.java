/*
 *Licensed under ..., see LICENSE.md
 *Authors: André Bernardes.
 *Created on: 28/03/2014, 11:23:34
 *Description: That class encrypt a password into a md5 hash string.
 */

package modelo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encrypter {
    /**
     *
     * @param pass
     * @return senha
     * Static method to encrypt a password into a md5 hash string*/
    public static String encryptMD5(String pass) {
	String senha = "";
	try {
	    MessageDigest md = MessageDigest.getInstance("MD5");

	    md.update(pass.getBytes());
	    BigInteger hash = new BigInteger(1, md.digest());
            
            int buffer = 16;
            int hashLength = 32;
            
	    senha = hash.toString(buffer);
	   
            if (senha.length() != hashLength) {
		senha = "0" + senha;
	    }
            else{
                //Nothing to do
            }
	}

	catch (NoSuchAlgorithmException ns) {
	    ns.printStackTrace();
	}
	return senha;
    }

}
