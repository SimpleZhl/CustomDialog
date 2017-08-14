package com.sty.custom.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sty.custom.dialog.utils.DialogUtils;

public class MainActivity extends AppCompatActivity {
    private Button successBtn;
    private Button errorBtn;
    private Button exitBtn;
    private Button successConfirmBtn;
    private Button errorConfirmBtn;
    private Button normalBtn;
    private Button progressBtn;
    private Button customEnterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setListeners();
    }

    private void initViews(){
        successBtn = (Button) findViewById(R.id.btn_success);
        errorBtn = (Button) findViewById(R.id.btn_error);
        exitBtn = (Button) findViewById(R.id.btn_exit);
        successConfirmBtn = (Button) findViewById(R.id.btn_success_confirm);
        errorConfirmBtn = (Button) findViewById(R.id.btn_error_confirm);
        normalBtn = (Button) findViewById(R.id.btn_normal);
        progressBtn = (Button) findViewById(R.id.btn_progress);
        customEnterBtn = (Button) findViewById(R.id.btn_input_type);
    }

    private void setListeners(){
        successBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.showSuccMessage(MainActivity.this, "Transaction ", new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {

                    }
                }, 3);
            }
        });

        errorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.showErrMessage(MainActivity.this, "error!", "Error message...", new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {

                    }
                }, 3);
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.showExitAppDialog(MainActivity.this);
            }
        });

        successConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.showSuccMessageWithConfirm(MainActivity.this, "Success message...", 3);
            }
        });

        errorConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.showErrMessageWithConfirm(MainActivity.this, "Error message...", 3);
            }
        });

        normalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.showNormalDialogWithConfirm(MainActivity.this, "Title", "Normal message...", 3, CustomAlertDialog.NORMAL_TYPE);
            }
        });

        progressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.showProcessDialog(MainActivity.this, "Title", "Message...", 3, CustomAlertDialog.PROGRESS_TYPE);
            }
        });

        customEnterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.showProcessDialog(MainActivity.this, "Title", "Message...", 3, CustomAlertDialog.CUSTOM_ENTER_TYPE);
            }
        });
    }
}
