package com.cf.carrecorder.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * The type Sp util.
 */
public class SPUtil {

    /**
     * The constant PREFERENCE_NAME.
     */
    public static String PREFERENCE_NAME = "CarRecorder";


    private static SharedPreferences sp;


    public static void init(Context context) {
        Log.i("SPUtil","init");
        sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }


    /**
     * 清除所有数据
     */
    public static void clear() {
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }


    /**
     * Gets shared preferences.
     *
     * @return the shared preferences
     */
    public static SharedPreferences getSharedPreferences() {
        return sp;
    }

    /**
     * put string preferences
     *
     * @param key   The name of the preference to modify
     * @param value The new value for the preference
     * @return True if the new values were successfully written to persistent         storage.
     */
    public static boolean putString(String key, String value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        boolean res = editor.commit();
        return res;
    }

    /**
     * get string preferences
     *
     * @param key The name of the preference to retrieve
     * @return The preference value if it exists, or null. Throws         ClassCastException if there is a preference with this name that         is not a string
     * @see #getString(String, String) #getString( String, String)#getString( String, String)
     */
    public static String getString(String key) {
        return getString(key, "");
    }

    /**
     * get string preferences
     *
     * @param key          The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws         ClassCastException if there is a preference with this name that         is not a string
     */
    public static String getString(String key,
                                   String defaultValue) {
        return sp.getString(key, defaultValue);
    }

    /**
     * put int preferences
     *
     * @param key   The name of the preference to modify
     * @param value The new value for the preference
     * @return True if the new values were successfully written to persistent         storage.
     */
    public static boolean putInt(String key, int value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        boolean res = editor.commit();
        return res;
    }

    /**
     * get int preferences
     *
     * @param key The name of the preference to retrieve
     * @return The preference value if it exists, or -1. Throws         ClassCastException if there is a preference with this name that         is not a int
     * @see #getInt(String, int) #getInt(String, int)#getInt( String, int)
     */
    public static int getInt(String key) {
        return getInt(key, -1);
    }

    /**
     * get int preferences
     *
     * @param key          The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws         ClassCastException if there is a preference with this name that         is not a int
     */
    public static int getInt(String key, int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

    /**
     * put long preferences
     *
     * @param key   The name of the preference to modify
     * @param value The new value for the preference
     * @return True if the new values were successfully written to persistent         storage.
     */
    public static boolean putLong(String key, long value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, value);


        boolean res = editor.commit();
        return res;
    }

    /**
     * get long preferences
     *
     * @param key The name of the preference to retrieve
     * @return The preference value if it exists, or -1. Throws         ClassCastException if there is a preference with this name that         is not a long
     * @see #getLong(String, long) #getLong(String, long)#getLong( String, long)
     */
    public static long getLong(String key) {
        return getLong(key, -1);
    }

    /**
     * get long preferences
     *
     * @param key          The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws         ClassCastException if there is a preference with this name that         is not a long
     */
    public static long getLong(String key, long defaultValue) {
        return sp.getLong(key, defaultValue);
    }

    /**
     * put float preferences
     *
     * @param key   The name of the preference to modify
     * @param value The new value for the preference
     * @return True if the new values were successfully written to persistent         storage.
     */
    public static boolean putFloat(String key, float value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat(key, value);

        boolean res = editor.commit();
        return res;
    }

    /**
     * get float preferences
     *
     * @param key The name of the preference to retrieve
     * @return The preference value if it exists, or -1. Throws         ClassCastException if there is a preference with this name that         is not a float
     * @see #getFloat(String, float) #getFloat(String, float)#getFloat(String, float)
     */
    public static float getFloat(String key) {
        return getFloat(key, -1);
    }

    /**
     * get float preferences
     *
     * @param key          The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws         ClassCastException if there is a preference with this name that         is not a float
     */
    public static float getFloat(String key, float defaultValue) {
        return sp.getFloat(key, defaultValue);
    }

    /**
     * put boolean preferences
     *
     * @param key   The name of the preference to modify
     * @param value The new value for the preference
     * @return True if the new values were successfully written to persistent         storage.
     */
    public static boolean putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);

        boolean res = editor.commit();
        return res;
    }

    /**
     * get boolean preferences, default is false
     *
     * @param key The name of the preference to retrieve
     * @return The preference value if it exists, or false. Throws         ClassCastException if there is a preference with this name that         is not a boolean
     * @see #getBoolean(String, boolean) #getBoolean( String, boolean)#getBoolean(String, boolean)
     */
    public static boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    /**
     * get boolean preferences
     *
     * @param key          The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws         ClassCastException if there is a preference with this name that         is not a boolean
     */
    public static boolean getBoolean(String key,
                                     boolean defaultValue) {
        return sp.getBoolean(key, defaultValue);
    }


    /**
     * <b>@Description:<b>根据key来删除<br/>
     * <b>@param context
     * <b>@param key
     * <b>@return<b>boolean<br/>
     * <b>@Author:<b>ccy<br/>
     * <b>@Since:<b>2014-8-21-上午11:48:12<br/>
     *
     * @param key the key
     * @return the boolean
     */
    public static boolean removeKey(String key) {
        try {
            SharedPreferences.Editor editor = sp.edit();
            editor.remove(key);
            editor.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
