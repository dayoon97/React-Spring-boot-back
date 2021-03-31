package com.mycom.config;

import java.io.Serializable;

public class JwtRequest implements Serializable {
	
	private static final long serialVersionUID = 5926468583005150707L;

    private String Email;
    private String password;

    //need default constructor for JSON Parsing
    public JwtRequest() {   }

    public JwtRequest(String Email, String password) {
        this.setUserEmail(Email);
        this.setPassword(password);
    }

    public String getUserEmail() {
        return this.Email;
    }

    public void setUserEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
