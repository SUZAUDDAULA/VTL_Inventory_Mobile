package com.opus_bd.stockmanagement.Utilts;

import java.util.ArrayList;

public class Constants {
    public static final float PROGRESSBAR_ALPHA = 0.6f;
    public static final float PROGRESSBAR_AFTER_FINISH_ALPHA = 1f;

    // Login error codes

    public static final String TOKEN_INVALID = "400";
    public static final String TOKEN_EXPIRED = "401";
    public static final String TOKEN_NOT_FOUND = "320";
    public static final String USER_NOT_FOUND = "404";

    public static final int DUMMY_USER = 0;

    public static final int MODE_PURCHASE = 1;
    public static final int MODE_SALE = 2;
    // Titles
    public static String BANGLA_TITLE = "বাংলা";
    public static String ENGLISH_TITLE = "ENG";
    public static ArrayList<String> rollList = new ArrayList<>();
    public static ArrayList<String> qrList = new ArrayList<>();
    public static ArrayList<Integer> rackIdList = new ArrayList<>();
    public static ArrayList<Integer> detailsList = new ArrayList<>();
    // Languages
    public static String ENGLISH = "en";
    public static String BANGLA = "bd";

    public static final String DATABASE_NAME = "winkel_db";

    public static final int PURCHASE_DRAFT_ORDER = 1;
    public static final int SALE_DRAFT_ORDER = 2;
}
