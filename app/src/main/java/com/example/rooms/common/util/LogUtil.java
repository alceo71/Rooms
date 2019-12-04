package com.example.rooms.common.util;

import android.util.Log;

public class LogUtil {

    // TAG usato nella libreria java.util
    private static final String TAG = "prova_room";

    // Il livello di verbosità dei messaggi per l'applicazione. Può essere modificato a runtime.
    public static Verbosity livello = Verbosity.DEBUG;

    /**
     * Messaggio di debug, il metodo fa qualche cosa solo se il valore di {@link LogUtil#livello} è DEBUG o superiore.
     *
     * @param messaggio
     */
    public static void debug(String messaggio){
        if(livello.ordinal() <= Verbosity.DEBUG.ordinal()){
            Log.d(TAG, messaggio);
        }
    }

    /**
     * Messaggio di informazione, il metodo fa qualche cosa solo se il valore di {@link LogUtil#livello} è INFO o superiore.
     *
     * @param messaggio
     */
    public static void info(String messaggio){
        if(livello.ordinal() <= Verbosity.INFO.ordinal()){
            Log.i(TAG, messaggio);
        }
    }

    /**
     * Messaggio di avvertimento, il metodo fa qualche cosa solo se il valore di {@link LogUtil#livello} è WARN o superiore.
     *
     * @param messaggio
     * @param e
     */
    public static void warn(String messaggio, Throwable e){
        if(livello.ordinal() <= Verbosity.WARN.ordinal()){
            if(e == null)
                Log.w(TAG, messaggio, e);
            else
                Log.w(TAG, messaggio);
        }
    }

    /**
     * Messaggio di avvertimento, il metodo fa qualche cosa solo se il valore di {@link LogUtil#livello} è WARN o superiore.
     *
     * @param messaggio
     */
    public static void warn(String messaggio){
        warn(messaggio, null);
    }


    /**
     * Messaggio di errore, il metodo fa qualche cosa solo se il valore di {@link LogUtil#livello} è ERROR o superiore.
     *
     * @param messaggio
     * @param e
     */
    public static void error(String messaggio, Throwable e){
        if(livello.ordinal() <= Verbosity.ERROR.ordinal()){
            if(e != null) {
                Log.e(TAG, messaggio, e);
            } else {
                Log.e(TAG, messaggio);
            }
        }
    }

    /**
     * Messaggio di errore, il metodo fa qualche cosa solo se il valore di {@link LogUtil#livello} è ERROR o superiore.
     *
     * @param messaggio
     */
    public static void error(String messaggio){
        error(messaggio, null);
    }

    public enum Verbosity {
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

}
