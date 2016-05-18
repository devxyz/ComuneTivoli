package comune.tivoli.rm.it.ComuneTivoli.util;

import android.content.SharedPreferences;

import java.util.Date;

/**
 * Created by stefano on 09/06/15.
 */
public class SharedPreferenceWrapper {


    private static final String KEY_DATA_ULTIMO_UPDATE_DATI_ESTERNI = "KEY_DATA_ULTIMO_UPDATE_DATI_ESTERNI";
    private static final String KEY_AUTOUPDATE_FLAG = "KEY_AUTOUPDATE_FLAG";
    private static final String KEY_AUTOUPDATE_MINUTES = "KEY_AUTOUPDATE_MINUTES";
    private final SharedPreferences preferences;

    public SharedPreferenceWrapper(SharedPreferences preferences) {
        this.preferences = preferences;
    }


    public SharedPreferences getPreferences() {
        return preferences;
    }


    public boolean getFlagAutoUpdate() {
        return preferences.getBoolean(KEY_AUTOUPDATE_FLAG, false);
    }

    public void setFlagAutoUpdate(boolean d) {
        SharedPreferences.Editor e = preferences.edit();
        e.putBoolean(KEY_AUTOUPDATE_FLAG, d);
        e.apply();
    }

    public int getMinutesAutoUpdate() {
        return preferences.getInt(KEY_AUTOUPDATE_MINUTES, 5);
    }

    public void setMinutesAutoUpdate(int d) {
        SharedPreferences.Editor e = preferences.edit();
        e.putInt(KEY_AUTOUPDATE_FLAG, d);
        e.apply();
    }


    public Date getDataUltimoDownloadDati() {
        return new Date(preferences.getLong(KEY_DATA_ULTIMO_UPDATE_DATI_ESTERNI, 0));
    }

    public void setDataUltimoDownloadDati(Date d) {
        SharedPreferences.Editor e = preferences.edit();
        e.putLong(KEY_DATA_ULTIMO_UPDATE_DATI_ESTERNI, d.getTime());
        e.apply();
    }


    public void clear() {
        SharedPreferences.Editor e = preferences.edit();
        e.clear();
        e.apply();
    }

}
