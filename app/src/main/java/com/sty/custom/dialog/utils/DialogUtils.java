package com.sty.custom.dialog.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.ConditionVariable;
import android.util.Log;
import android.view.KeyEvent;

import com.sty.custom.dialog.CustomAlertDialog;
import com.sty.custom.dialog.MyApplication;
import com.sty.custom.dialog.R;

/**
 * Created by shity on 2017/8/8/0008.
 */

public class DialogUtils {
    public static CustomAlertDialog dialog;
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
                                      final OnDismissListener listener, final int timeout, final boolean isNewLayout){
        MyApplication.getApp().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(dialog != null){
                    dialog.dismiss();
                }
                dialog = new CustomAlertDialog(context, CustomAlertDialog.ERROR_TYPE, true, timeout, isNewLayout);
                dialog.setTitleText(title);
                dialog.setContentText(msg);
                dialog.show();
                dialog.setCanceledOnTouchOutside(true);
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
                                        final OnDismissListener listener, final int timeout,
                                        final boolean isNewLayout){
        if(context == null){
            return;
        }
        MyApplication.getApp().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(dialog != null){
                    dialog.dismiss();
                }
                dialog = new CustomAlertDialog(context, CustomAlertDialog.SUCCESS_TYPE, true, timeout, isNewLayout);
                dialog.setTitleText(context.getString(R.string.dialog_trans_succ_liff, title));
                dialog.showContentText(false);
                dialog.show();
                dialog.setCanceledOnTouchOutside(true);
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

    public static void showSuccMessageWithConfirm(final Context context, final String message, final boolean isNewLayout){
        showMessageWithConfirm(context, message, CustomAlertDialog.SUCCESS_TYPE, isNewLayout);
    }

    public static void showErrMessageWithConfirm(final Context context, final String message, final boolean isNewLayout){
        showMessageWithConfirm(context, message, CustomAlertDialog.ERROR_TYPE, isNewLayout);
    }

    /**
     * 带确认按钮的提示信息
     * @param context
     * @param message
     * @param alertType
     */
    public static void showMessageWithConfirm(final Context context, final String message,
                                              final int alertType, final boolean isNewLayout){
        MyApplication.getApp().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(dialog != null){
                    dialog.dismiss();
                }
                dialog = new CustomAlertDialog(context, alertType, isNewLayout);
                dialog.setContentText(message);
                dialog.show();
                dialog.showConfirmButton(true);
                dialog.setConfirmClickListener(new CustomAlertDialog.OnCustomClickListener() {
                    @Override
                    public void onClick(CustomAlertDialog alertDialog) {
                        dialog.dismiss();
                    }
                });
            }
        });
        //cv.block();
    }

    /**
     * 带进度条样式的对话框
     * @param context
     * @param message
     * @param timeout
     * @param alertType
     */
    public static void showProcessDialog(final Context context, final String title,
                                         final String message, final int timeout, final int alertType,
                                         final boolean isNewLayout){
        MyApplication.getApp().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(dialog != null){
                    dialog.dismiss();
                }
                dialog = new CustomAlertDialog(context, alertType, timeout, isNewLayout);
                dialog.setTitleText(title);
                dialog.setContentText(message);
                dialog.show();
                dialog.setCancelable(false);
                dialog.setTimeout(timeout);
                dialog.setOnDismissListener(new OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        //dialog.dismiss();
                    }
                });
            }
        });
    }

    public static void showInputTypeDialog(final Context context, final String title, final String errTipsText,
                                           final int alertType, final boolean isNewLayout){
        if(dialog != null){
            dialog.dismiss();
        }
        dialog = new CustomAlertDialog(context, alertType, isNewLayout);
        dialog.setTitleText(title);
        dialog.show();
        dialog.setErrTipsText(errTipsText);
        dialog.setCancelable(false);
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
            }
        });
        dialog.showCancelButton(true);
        dialog.showConfirmButton(true);
    }

    /**
     * 显示对话框
     * @param context
     * @param title
     * @param message
     * @param timeout
     * @param alertType
     */
    public static void showNormalDialogWithConfirm(final Context context, final String title,
                                                   final String message, final int timeout,
                                                   final int alertType, final boolean isNewLayout){
        MyApplication.getApp().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(dialog != null){
                    dialog.dismiss();
                }
                dialog = new CustomAlertDialog(context, alertType, timeout, isNewLayout);
                dialog.setTitleText(title);
                dialog.setContentText(message);
                dialog.show();
                dialog.setCancelable(false);
                dialog.setTimeout(timeout);
                dialog.showConfirmButton(true);
            }
        });
    }
    /**
     * 退出当前应用
     * @param context
     */
    public static void showExitAppDialog(final Context context, final boolean isNewLayout){
        if(dialog != null){
            dialog.dismiss();
        }
        dialog = new CustomAlertDialog(context, CustomAlertDialog.NORMAL_TYPE, isNewLayout);
        dialog.setTitleText(context.getString(R.string.exit_app));
        dialog.show();
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
        dialog.showCancelButton(true);
        dialog.showConfirmButton(true);
    }

    public static void showImageTypeDialog(final Context context, String contentMsg, int imageResourceId,
                                           final boolean isNewLayout){
        if(dialog != null){
            dialog.dismiss();
        }
        dialog = new CustomAlertDialog(context, CustomAlertDialog.IMAGE_TYPE, isNewLayout);
        dialog.setContentText(contentMsg);
        dialog.show();
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
            }
        });
        dialog.setImage(imageResourceId);
        dialog.showCancelButton(true);
        dialog.showConfirmButton(true);
    }
}




















