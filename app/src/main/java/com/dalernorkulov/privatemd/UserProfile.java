package com.dalernorkulov.privatemd;

/**
 * Created by Daler on 6/13/2017.
 */

public class UserProfile {
    private String name;
    private String password;

    public UserProfile(String name, String password){
        this.name=name;
        this.password=password;
    }
    public String getName(){
        return name;
    }
    protected String getPassword(){
        return password;
    }

}
