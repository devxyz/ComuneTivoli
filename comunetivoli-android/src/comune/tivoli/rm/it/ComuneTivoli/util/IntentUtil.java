package comune.tivoli.rm.it.ComuneTivoli.util;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created by stefano on 04/05/16.
 */
public class IntentUtil {
    public static Intent openWebBrowser(String url){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        return i;
    }
    /**
     * ritorna il valore dell'intent, e in mancanza di esso quello del boundle
     *
     * @param i
     * @param s
     * @param label
     * @return
     */
    public static int getExtraInt(Intent i, Bundle s, String label, int defaultValue) {
        if (!_isEmpty(i, label)) return _getInt(i.getExtras(), label);
        if (!_isEmpty(s, label)) return _getInt(s, label);
        return defaultValue;
    }

    /**
     * ritorna il valore dell'intent, e in mancanza di esso quello del boundle
     *
     * @param i
     * @param s
     * @param label
     * @return
     */
    public static long getExtraLong(Intent i, Bundle s, String label, int defaultValue) {
        if (!_isEmpty(i, label)) return _getLong(i.getExtras(), label);
        if (!_isEmpty(s, label)) return _getLong(s, label);
        return defaultValue;
    }

    /**
     * ritorna il valore dell'intent, e in mancanza di esso quello del boundle
     *
     * @param i
     * @param s
     * @param label
     * @return
     */
    public static double getExtraDouble(Intent i, Bundle s, String label, double defaultValue) {
        if (!_isEmpty(i, label)) return _getDouble(i.getExtras(), label);
        if (!_isEmpty(s, label)) return _getDouble(s, label);
        return defaultValue;

    }

    /**
     * ritorna il valore dell'intent, e in mancanza di esso quello del boundle
     *
     * @param i
     * @param s
     * @param label
     * @return
     */
    public static String getExtraString(Intent i, Bundle s, String label, String defaultValue) {
        if (!_isEmpty(i, label)) return _getString(i.getExtras(), label);
        if (!_isEmpty(s, label)) return _getString(s, label);
        return defaultValue;
    }

    private static int _getInt(Bundle i, String label) {
        if (_isEmpty(i, label)) return 0;
        return i.getInt(label);
    }

    private static long _getLong(Bundle i, String label) {
        if (_isEmpty(i, label)) return 0;
        return i.getLong(label);
    }

    private static String _getString(Bundle i, String label) {
        if (_isEmpty(i, label)) return null;
        return i.getString(label);
    }

    private static double _getDouble(Bundle i, String label) {
        if (_isEmpty(i, label)) return 0;
        return i.getDouble(label);
    }

    private static boolean _isEmpty(Intent i, String label) {
        return i == null || i.getExtras() == null || !i.getExtras().containsKey(label);
    }

    private static boolean _isEmpty(Bundle i, String label) {
        return i == null || !i.containsKey(label);
    }


}
