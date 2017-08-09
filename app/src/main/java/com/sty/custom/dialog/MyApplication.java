package com.sty.custom.dialog;

import android.app.Application;
import android.os.Handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by shity on 2017/8/9/0009.
 */

public class MyApplication extends Application {
    public static MyApplication mApp;

    private Handler handler;
    private ExecutorService backgroundExecutor;

    public static MyApplication getApp() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.mApp = this;

        handler = new Handler();
        backgroundExecutor = Executors.newFixedThreadPool(10, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "Background executor service");
                thread.setPriority(Thread.MIN_PRIORITY);
                thread.setDaemon(true);
                return thread;
            }
        });
    }

    public void runOnUiThread(final Runnable runnable){
        handler.post(runnable);
    }

    public void runOnUiThreadDelay(final Runnable runnable, long delayMillis){
        handler.postDelayed(runnable, delayMillis);
    }

    public void runInBackground(final Runnable runnable){
        backgroundExecutor.submit(runnable);
    }
}
