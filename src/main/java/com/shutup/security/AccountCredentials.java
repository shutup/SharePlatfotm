package com.shutup.security;

/**
 * Created by Tom on 1/11/17.
 */
public class AccountCredentials {
    private String username;
    private String password;

    protected AccountCredentials() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
