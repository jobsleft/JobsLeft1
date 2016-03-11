package com.convene.jl.info;

public class Password {
	private String salt;
	private String hashedpassword;

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSalt() {
		return salt;
	}

	public void setHashedpassword(String hashedpassword) {
		this.hashedpassword = hashedpassword;
	}

	public String getHashedpassword() {
		return hashedpassword;
	}
}
