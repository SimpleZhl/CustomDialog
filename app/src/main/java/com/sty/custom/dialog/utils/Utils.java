package com.sty.custom.dialog.utils;

import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;

/**
 * Created by shity on 2017/8/9/0009.
 */

public class Utils {
    private Utils(){
        //do nothing
    }

    public static void wakeupScreen(int timeout, Context context, Handler handler){
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        final PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP
        | PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "bright");
        wl.acquire();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                wl.release();
            }
        }, 1000L * (timeout + 1));
    }

}
