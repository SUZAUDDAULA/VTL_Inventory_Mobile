package com.opus_bd.stockmanagement.Utilts;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private static final String SHARED_PREF_NAME = "LostAndFound";
    private static final String KEY_TOKEN = "APPTOKEN";

    public static final String BEARER = "Bearer ";
    private static final String KEY_CARTS = "cart";
    private static final String KEY_USERNAME = "UserName";
    private static final String KEY_STODEID = "StoreID";
     private static final String KEY_TIMESTAMP = "timestamp";
    private static SharedPrefManager mInstance;
    private Context mCtx;
    public SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }
    public void saveToken(String token) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_TOKEN, token);
        editor.apply();
    }

    public String getToken() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_TOKEN, null);
    }
    public void clearToken() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,
                Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(KEY_TOKEN).apply();
    }
  /*  public void saveStoreID(String StoreID) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_STODEID, StoreID);
        editor.apply();
    }

    public String getStoreID() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_STODEID,null);
    }

    *//* *//*


    public void clearOrder() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,
                Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(KEY_CARTS).apply();
    }

    public void updateOrder(ArrayList<AddtoCartModel> checkOutModels) {
        clearOrder();
        Gson gson = new Gson();
        String tempOrders = gson.toJson(checkOutModels);

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_CARTS, tempOrders);
        editor.apply();
    }

    public void removeCart(AddtoCartModel addtoCartModel) {

        ArrayList<AddtoCartModel> addtoCartModels = getCart();

        if (addtoCartModels != null) {
            addtoCartModels.remove(addtoCartModel);
            Utilities.showLogcatMessage(" Remove " + addtoCartModels.remove(addtoCartModel));
            saveCart(addtoCartModels);
        }

    }



    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }


    // Clear everything
    public void clearAll() {

        clearOrder();
    }

    // Save TimeStamp
    public void saveTimeStamp(String timestamp) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_TIMESTAMP, timestamp);
        editor.apply();
    }

    public String getTimeStamp() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_TIMESTAMP, "");
    }*/
}