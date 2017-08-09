package com.sty.custom.dialog.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.view.KeyEvent;

import com.sty.custom.dialog.CustomAlertDialog;
import com.sty.custom.dialog.MyApplication;
import com.sty.custom.dialog.R;

/**
 * Created by shity on 2017/8/8/0008.
 */

public class DialogUtils {
    private DialogUtils(){
        //do nothing
    }

    /**
     * 提示错误信息
     * @param context
     * @param title
     * @param msg
     * @param listener
     * @param timeout
     */
    public static void showErrMessage(final Context context, final String title, final String msg,
                                      final OnDismissListener listener, final int timeout){
        MyApplication.getApp().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                CustomAlertDialog dialog = new CustomAlertDialog(context, CustomAlertDialog.ERROR_TYPE, true, timeout);
                dialog.setTitleText(title);
                dialog.setContentText(msg);
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
                dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                        return keyCode == KeyEvent.KEYCODE_BACK;
                    }
                });
                dialog.setOnDismissListener(listener);
            }
        });
    }

    /**
     * 单行提示成功信息
     * @param context
     * @param title
     * @param listener
     * @param timeout
     */
    public static void showSuccMessage(final Context context, final String title,
                                       final OnDismissListener listener, final int timeout){
        if(context == null){
            return;
        }
        MyApplication.getApp().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                CustomAlertDialog dialog = new CustomAlertDialog(context, CustomAlertDialog.SUCCESS_TYPE, true, timeout);
                dialog.showContentText(false);
                dialog.setTitleText(context.getString(R.string.dialog_trans_succ_liff, title));
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
                dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                        return keyCode == KeyEvent.KEYCODE_BACK;
                    }
                });
                dialog.setOnDismissListener(listener);
            }
        });
    }

    /**
     * 退出当前应用
     * @param context
     */
    public static void showExitAppDialog(final Context context){
        final CustomAlertDialog dialog = new CustomAlertDialog(context, CustomAlertDialog.NORMAL_TYPE);
        dialog.setCancelClickListener(new CustomAlertDialog.OnCustomClickListener() {
            @Override
            public void onClick(CustomAlertDialog alertDialog) {
                dialog.dismiss();
            }
        });
        dialog.setConfirmClickListener(new CustomAlertDialog.OnCustomClickListener() {
            @Override
            public void onClick(CustomAlertDialog alertDialog) {
                dialog.dismiss();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        dialog.show();
        dialog.setNormalText(context.getString(R.string.exit_app));
        dialog.showCancelButton(true);
        dialog.showConfirmButton(true);
    }
}




















