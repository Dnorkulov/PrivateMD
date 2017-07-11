package com.dalernorkulov.privatemd;

/**
 * Created by Daler on 6/23/2017.
 */

import java.util.Calendar;
/**
 * Created by thera on 6/19/2017.
 */

public class User {
    private String userName;
    private String password;
    private int age;
    //stores sex as true for male and false for female
    private boolean sex;
    private boolean smoker;
    //stored as a six digit area code
    private int location;
    //Stored for the times the account was first created and the day it was last used
    private Calendar lastVisit;
    private Calendar firstVisit;

    public User() {

    }
    public User(String userNam){
        userName = userNam;
    }

    //standard setters
    public void setUserName(String x) {
        userName = x;
    }

    public void setPassword(String x) {
        password = x;
    }

    public void setAge(int x) {
        age = x;
    }

    public void setSex(boolean x) {
        sex = x;
    }

    public void setSmoker(boolean x) {
        smoker = x;
    }

    public void setLocation(int x) {
        location = x;
    }

    public void setLastVisit(Calendar x) {
        lastVisit = x;
    }

    //standard accessors
    public String getUserName() {
        return userName;
    }

    public boolean passwordConfirmation(String temp) {
        //checks if the password is correct for now simply without anything complicated
        if (temp.compareTo(password) == 0)
            return true;
        else
            return false;
    }

    public int getAge() {
        return age;
    }

    public boolean getSex() {
        return sex;
    }

    public boolean getSmokes() {
        return smoker;
    }

    public Calendar getLastVisit() {
        return lastVisit;
    }

    public Calendar getFirstVisit() {
        return firstVisit;
    }

    public int getLocation() {
        return location;
    }

    public String toString() {
        String z = "name:" + userName + "/n" + "password: " + password + " age: " + age;
        return z;
    }
}