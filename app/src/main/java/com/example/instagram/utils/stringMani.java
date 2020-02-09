package com.example.instagram.utils;

public class stringMani {
    public static String expandusername(String username ){
        return username.replace (".","");
    }
    public static  String condenseuser(String username){
        return username.replace ("",".");
    }
}