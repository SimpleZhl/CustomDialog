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
    }

    private void setListeners(){
        successBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.showSuccMessage(MainActivity.this, "Transaction ", new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {

                    }
                }, 5);
            }
        });

        errorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.showErrMessage(MainActivity.this, "error!", "Error message...", new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {

                    }
                }, 5);
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.showExitAppDialog(MainActivity.this);
            }
        });
    }
}
