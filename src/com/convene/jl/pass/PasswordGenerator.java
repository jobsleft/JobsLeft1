package com.convene.jl.pass;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import com.convene.jl.info.Password;



public class PasswordGenerator {
public Password createPassword(String password) throws Exception {
		
		Password ps = new Password();
		Random r = new Random();

		String salt = Long.toString(Math.abs(r.nextLong()), 36);
		
		if (salt.length() >16)
		{
		    salt = salt.substring(0,16);
		}
		//String saltedPassword = "my-salt-text" + password;
		String saltedPassword = salt + password;
		String hashedPassword = generateHash(saltedPassword);
		
		ps.setSalt(salt);
		ps.setHashedpassword(hashedPassword);
		return ps;

   }
	
	// method to verify password.
	
	 public boolean authenticatePassword(String passdb, String salt, String password) throws Exception {
			Boolean isAuthenticated = false;

			// remember to use the same SALT value,used while storing password
			// for the first time.
			// password is input password from user.
			//passdb is password from database.
			//String saltedPassword = "my-salt-text" + password;
			String saltedPassword = salt + password;
			String hashedPassword = generateHash(saltedPassword);

			String storedPasswordHash = passdb;
			if(hashedPassword.equals(storedPasswordHash)){
				isAuthenticated = true;
			}else{
				isAuthenticated = false;
			}
			return isAuthenticated;
        }
	
	 // method to generate hash.
	 
		public String generateHash(String input) {
			StringBuilder hash = new StringBuilder();

			try {
				MessageDigest sha = MessageDigest.getInstance("SHA-1");
				byte[] hashedBytes = sha.digest(input.getBytes());
				char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
						'a', 'b', 'c', 'd', 'e', 'f' };
				for (int idx = 0; idx < hashedBytes.length; ++idx) {
					byte b = hashedBytes[idx];
					hash.append(digits[(b & 0xf0) >> 4]);
					hash.append(digits[b & 0x0f]);
				}
			} catch (NoSuchAlgorithmException e) {
				// handle error here.
			}

			return hash.toString();
		}

}
