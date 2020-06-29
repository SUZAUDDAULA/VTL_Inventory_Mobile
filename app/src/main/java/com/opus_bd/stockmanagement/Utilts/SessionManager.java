package com.opus_bd.stockmanagement.Utilts;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionManager {

    private SharedPreferences prefs;

    public SessionManager(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setToken(String nid) {
        prefs.edit().putString("token", nid).commit();
    }

    public String getToken() {
        String nid = prefs.getString("token", "");
        return nid;
    }

    public void setLoggedIn(boolean nid) {
        prefs.edit().putBoolean("loggedIn", nid).commit();
    }

    public boolean getLoggedIn() {
        boolean nid = prefs.getBoolean("loggedIn", false);
        return nid;
    }

    public void setSuperAdmin(boolean nid) {
        prefs.edit().putBoolean("superAdmin", nid).commit();
    }

    public boolean isSuperAdmin() {
        boolean nid = prefs.getBoolean("superAdmin", false);
        return nid;
    }

    public void setuserType(String nid) {
        prefs.edit().putString("userType", nid).commit();
    }

    public String getUserType() {
        String nid = prefs.getString("userType", "");
        return nid;
    }

    public void setuserName(String nid) {
        prefs.edit().putString("userName", nid).commit();
    }

    public String getUserName() {
        String nid = prefs.getString("userName", "");
        return nid;
    }

    public void setuserId(String nid) {
        prefs.edit().putString("id", nid).commit();
    }

    public String getUserId() {
        String nid = prefs.getString("id", "");
        return nid;
    }


    public void setSound(boolean nid) {
        prefs.edit().putBoolean("sound", nid).commit();
    }

    public boolean getsound() {
        boolean nid = prefs.getBoolean("sound", true);
        return nid;
    }

    public void setnewCaseNoti(boolean nid) {
        prefs.edit().putBoolean("newCaseNoti", nid).commit();
    }

    public boolean getnewCaseNoti() {
        boolean nid = prefs.getBoolean("newCaseNoti", true);
        return nid;
    }

    public void setNewMsgNoti(boolean nid) {
        prefs.edit().putBoolean("newMsgNoti", nid).commit();
    }

    public boolean getNewMsgNoti() {
        boolean nid = prefs.getBoolean("newMsgNoti", true);
        return nid;
    }

    public void set_lang(String usename) {
        prefs.edit().putString("lang", usename).commit();
    }

    public String get_lang() {
        String id = prefs.getString("lang", "bn");
        return id;
    }

    public void set_userPhoto(String usename) {
        prefs.edit().putString("userPhoto", usename).commit();
    }

    public String get_userPhoto() {
        String id = prefs.getString("userPhoto", "");
        return id;
    }

    public void set_userData(String usename) {
        prefs.edit().putString("userData", usename).commit();
    }

    public String get_userData() {
        String id = prefs.getString("userData", "");
        return id;
    }

    public void set_userEmail(String usename) {
        prefs.edit().putString("Email", usename).commit();
    }

    public String get_userEmail() {
        String id = prefs.getString("Email", "");
        return id;
    }

    public void set_userPassword(String usename) {
        prefs.edit().putString("password", usename).commit();
    }

    public String get_userPassword() {
        String id = prefs.getString("password", "");
        return id;
    }

    public void setUserPhotoBinary(String usename) {
        prefs.edit().putString("userPicBin", usename).commit();
    }

    public String getUserPhotoBinary() {
        String id = prefs.getString("userPicBin", "");
        return id;
    }

    public void setCartData(String usename) {
        prefs.edit().putString("cart", usename).commit();
    }

    public void removeCartData() {
        prefs.edit().remove("cart").commit();
    }

    public String getCartData() {
        String id = prefs.getString("cart", "");
        return id;
    }

    public void setWishListData(String usename) {
        prefs.edit().putString("wish", usename).commit();
    }

    public String getWishListData() {
        String id = prefs.getString("wish", "");
        return id;
    }
}