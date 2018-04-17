package makanbu.com.makanbu.model.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class SharedPref {

    private static final String TAG = "SharedPref";

    private static SharedPreferences getPref() {
        Context context = App.getContext();
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void saveString(String key, String value) {
        Log.d(TAG, "saveString: " + value);
        getPref().edit()
                .putString(key, value)
                .apply();
    }

    public static String getString(String key) {
        Log.d(TAG, "getString: " + getPref().getString(key, null));
        return getPref().getString(key, null);
    }


    public static void deleteString(String key) {
        getPref().edit()
                .remove(key)
                .apply();
    }
}