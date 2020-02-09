package com.example.instagram.utils.user;

public class user {
    private String user_id;
    private long phoneno;
    private String email;
    private String username;

    public user(String user_id, long phoneno, String email, String username) {
        this.user_id = user_id;
        this.phoneno = phoneno;
        this.email = email;
        this.username = username;
    }
    public user(){

    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public long getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(long phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "user{" +
                "user_id='" + user_id + '\'' +
                ", phoneno='" + phoneno + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

