package com.example.instagram.utils.user;

public class user_act_settings {

    private String description;
    private String display_name;
    private int followers;
    private int following;
    private int posts;
    private String profile_photo;
    private String username;

    public user_act_settings(String description, String display_name, int followers, int following, int posts, String profilephoto,  String username) {
        this.description = description;
        this.display_name = display_name;
        this.followers = followers;
        this.following = following;
        this.posts = posts;
        this.profile_photo = profilephoto;
        this.username = username;
    }

        public  user_act_settings(){

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public String getProfilephoto() {
        return profile_photo;
    }

    public void setProfilephoto(String profilephoto) {
        this.profile_photo = profilephoto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "user_act_settings{" +
                "description='" + description + '\'' +
                ", display_name='" + display_name + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                ", posts=" + posts +
                ", profilephoto='" + profile_photo + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}



