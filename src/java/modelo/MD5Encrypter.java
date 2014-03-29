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
    
    /*Static method to encrypt a password into a md5 hash string*/
    public static String encryptMD5(String pass) {
	String senha = "";
	try {
	    MessageDigest md = MessageDigest.getInstance("MD5");

	    md.update(pass.getBytes());
	    BigInteger hash = new BigInteger(1, md.digest());
	    senha = hash.toString(16);
	    if (senha.length() != 32) {
		senha = "0" + senha;
	    }
	}

	catch (NoSuchAlgorithmException ns) {
	    ns.printStackTrace();
	}
	return senha;
    }

}
