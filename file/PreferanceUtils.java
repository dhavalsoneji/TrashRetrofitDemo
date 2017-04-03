package com.provoyants.iper.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.provoyants.iper.model.Counts;
import com.provoyants.iper.model.LoginResponse;

/**
 * Created by Dhaval Soneji Riontech on 9/11/16.
 */
public class PreferanceUtils {
    /**
     * Insert string value in Shared Preferences
     *
     * @param context of application
     * @param value   to store in preferences
     * @param key     using which value is mapped
     * @return
     */
    public static boolean putStringInPreferences(final Context context,
                                                 final String value, final String key) {
        final SharedPreferences sharedPreferences = context
                .getSharedPreferences(AppConstants.PREFERENCE_NAME,
                        Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
        return true;
    }

    /**
     * Get Data from preferance
     *
     * @param context
     * @param defaultValue
     * @param key
     * @return
     */
    public static String getStringFromPreferences(final Context context,
                                                  final String defaultValue, final String key) {
        final SharedPreferences sharedPreferences = context
                .getSharedPreferences(AppConstants.PREFERENCE_NAME,
                        Context.MODE_PRIVATE);
        final String temp = sharedPreferences.getString(key, defaultValue);
        return temp;
    }

    /**
     * Insert booblean in preferance
     *
     * @param context
     * @param value
     * @param key
     * @return
     */
    public static boolean putBooleanInPreferences(final Context context,
                                                  final boolean value, final String key) {
        final SharedPreferences sharedPreferences = context
                .getSharedPreferences(AppConstants.PREFERENCE_NAME,
                        Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
        return true;
    }

    /**
     * Get boolean from preferance
     *
     * @param context
     * @param defaultValue
     * @param key
     * @return
     */
    public static boolean getBooleanFromPreferences(final Context context,
                                                    final boolean defaultValue, final String key) {
        final SharedPreferences sharedPreferences = context
                .getSharedPreferences(AppConstants.PREFERENCE_NAME,
                        Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    /**
     * Insert integer value in preferences
     *
     * @param context
     * @param value
     * @param key
     * @return
     */
    public static boolean putIntegerInPreferences(final Context context,
                                                  final int value, final String key) {
        final SharedPreferences sharedPreferences = context
                .getSharedPreferences(AppConstants.PREFERENCE_NAME,
                        Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
        return true;
    }

    /**
     * Return integer preference value
     *
     * @param context
     * @param defaultValue
     * @param key
     * @return
     */
    public static int getIntegerFromPreferences(final Context context,
                                                final int defaultValue, final String key) {
        final SharedPreferences sharedPreferences = context
                .getSharedPreferences(AppConstants.PREFERENCE_NAME,
                        Context.MODE_PRIVATE);
        final int temp = sharedPreferences.getInt(key, defaultValue);
        return temp;
    }

    /**
     * get is Already Login
     *
     * @param context
     * @return
     */
    public static boolean isLoggedIn(Context context) {
        return PreferanceUtils.getBooleanFromPreferences(context, false,
                AppConstants.IS_REGISTERED);
    }

    /**
     * Set is Already Login
     *
     * @param context
     * @param isRegistered
     */
    public static void setIsLoggedIn(Context context, boolean isRegistered) {
        PreferanceUtils.putBooleanInPreferences(context, isRegistered,
                AppConstants.IS_REGISTERED);
    }


    /**
     * @param context
     * @param users
     */
    public static void setLoginUserObject(Context context, String users) {
        PreferanceUtils.putStringInPreferences(context, users,
                AppConstants.USER);
    }

    /**
     * @param context
     * @return
     */
    public static LoginResponse getLoginUserObject(Context context) {
        return new Gson().fromJson(PreferanceUtils.getStringFromPreferences(context, "",
                AppConstants.USER), LoginResponse.class);
    }

    /**
     * @param context
     * @param users
     */
    public static void setUserToken(Context context, String users) {
        PreferanceUtils.putStringInPreferences(context, users,
                AppConstants.USER_TOKEN);
    }

    /**
     * @param context
     * @return
     */
    public static String getUserToken(Context context) {
        return PreferanceUtils.getStringFromPreferences(context,
                "", AppConstants.USER_TOKEN);
    }

    /**
     * @param context
     * @param users
     */
    public static void setImei(Context context, String users) {
        PreferanceUtils.putStringInPreferences(context, users,
                AppConstants.USER_IMEI);
    }

    /**
     * @param context
     * @return
     */
    public static String getImei(Context context) {
        return PreferanceUtils.getStringFromPreferences(context,
                "", AppConstants.USER_IMEI);
    }


    /**
     * Clear Data From Preference
     *
     * @param ctx
     */
    public static void clearPreference(Context ctx) {
        SharedPreferences settings = ctx.getSharedPreferences(AppConstants.PREFERENCE_NAME, ctx.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.commit();
    }

    /**
     * @param context
     * @param users
     */
    public static void setCurrentUser(Context context, String users) {
        PreferanceUtils.putStringInPreferences(context, users,
                AppConstants.CURRENT_USER);
    }

    /**
     * @param context
     * @return
     */
    public static String getCurrentUser(Context context) {
        return PreferanceUtils.getStringFromPreferences(context, "",
                AppConstants.CURRENT_USER);
    }

    /**
     * @param context
     * @param users
     */
    public static void setUsername(Context context, String users) {
        PreferanceUtils.putStringInPreferences(context, users,
                AppConstants.USERNAME);
    }

    /**
     * @param context
     * @return
     */
    public static String getUsername(Context context) {
        return PreferanceUtils.getStringFromPreferences(context, "",
                AppConstants.USERNAME);
    }

    /**
     * @param context
     * @param users
     */
    public static void setPassword(Context context, String users) {
        PreferanceUtils.putStringInPreferences(context, users,
                AppConstants.PASSWORD);
    }

    /**
     * @param context
     * @return
     */
    public static String getPassword(Context context) {
        return PreferanceUtils.getStringFromPreferences(context, "",
                AppConstants.PASSWORD);
    }

    /**
     * Set GCM Token
     *
     * @param context
     * @param token
     */
    public static void setGCMID(Context context, String token) {
        PreferanceUtils.putStringInPreferences(context, token,
                AppConstants.GCM_TOKEN);
    }

    /**
     * Get GCM Token
     *
     * @param context
     * @return
     */
    public static String getRegGCMID(Context context) {
        return PreferanceUtils.getStringFromPreferences(context, "",
                AppConstants.GCM_TOKEN);
    }

    /**
     * set TimetableRecyclerRow From Preference
     *
     * @param context
     * @param position
     */
    public static void setCurrentUserPosition(Context context, int position) {
        PreferanceUtils.putIntegerInPreferences(context, position,
                AppConstants.CURRENT_USER_POSITION);
    }

    /**
     * Get TimetableRecyclerRow From Preference
     *
     * @param context
     * @return
     */
    public static int getCurrentUserPosition(Context context) {
        return PreferanceUtils.getIntegerFromPreferences(context, -1,
                AppConstants.CURRENT_USER_POSITION);
    }

    public static void setNoticeCounts(Context context, Counts counts) {
        PreferanceUtils.putStringInPreferences(context, new Gson().toJson(counts),
                AppConstants.COUNTS);

        if (counts.getCount() > 0)
            PreferanceUtils.setHasNoticeCounts(context, true);
        else
            PreferanceUtils.setHasNoticeCounts(context, false);
    }

    public static Counts getNoticeCounts(Context context) {
        return new Gson().fromJson(PreferanceUtils.getStringFromPreferences(context, "",
                AppConstants.COUNTS), Counts.class);
    }

    public static void setHasNoticeCounts(Context context, boolean flag) {
        PreferanceUtils.putBooleanInPreferences(context, flag, AppConstants.COUNTS_BOOLEAN);
    }

    public static boolean hasNoticeCounts(Context context) {
        return PreferanceUtils.getBooleanFromPreferences(context, false, AppConstants.COUNTS_BOOLEAN);
    }

    /*public static List<Counts> getNoticeCounts(Context context) {
        return new Gson().fromJson(PreferanceUtils.getStringFromPreferences(context, "",
                AppConstants.COUNTS), new TypeToken<ArrayList<Counts>>() {
        }.getType());
    }*/
}
