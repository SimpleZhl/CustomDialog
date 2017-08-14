package com.sty.custom.dialog.utils;

import android.os.CountDownTimer;
import android.util.Log;

/**
 * Created by shity on 2017/8/8/0008.
 */

public class TickTimer {

    public static final int DEFAULT_TIMEOUT = 60;

    private Timer timer;
    private OnTickTimerListener listener;

    public interface OnTickTimerListener{
        void onTick(long leftTime);

        void onFinish();
    }

    private class Timer extends CountDownTimer {
        private OnTickTimerListener listener;

        Timer(long timeout, long tickInterval){
            super(timeout * 1000, tickInterval * 1000);
        }

        void setTimeCountListener(OnTickTimerListener listener){
            this.listener = listener;
        }

        @Override
        public void onTick(long millisUntilFinished) {
            if(listener != null){
                listener.onTick(millisUntilFinished / 1000);
            }
            Log.i("Tag", "millisUntilFinished:-->" + millisUntilFinished);
        }

        @Override
        public void onFinish() {
            if(listener != null){
                listener.onFinish();
            }
        }
    }

    public TickTimer(OnTickTimerListener listener){
        this.listener = listener;
    }

    public void start(){
        if(timer != null){
            timer.cancel();
        }
        updateTimer(DEFAULT_TIMEOUT);
        timer.start();
    }

    public void start(int timeout){
        if(timer != null){
            timer.cancel();
        }
        updateTimer(timeout);
        timer.start();
    }

    public void stop(){
        if(timer != null){
            timer.cancel();
            timer = null;
        }
    }

    private void updateTimer(int timeout){
        timer = new Timer(timeout, 1);
        timer.setTimeCountListener(listener);
    }
}
