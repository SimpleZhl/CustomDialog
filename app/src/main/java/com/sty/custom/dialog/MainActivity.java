package com.sty.custom.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sty.custom.dialog.utils.DialogUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button normalBtn;
    private Button exitBtn;
    private Button successBtn;
    private Button successConfirmBtn;
    private Button errorBtn;
    private Button errorConfirmBtn;
    private Button progressBtn;
    private Button customEnterBtn;
    private Button imageBtn;

    private Button normalBtnNew;
    private Button exitBtnNew;
    private Button successBtnNew;
    private Button successConfirmBtnNew;
    private Button errorBtnNew;
    private Button errorConfirmBtnNew;
    private Button progressBtnNew;
    private Button customEnterBtnNew;
    private Button imageBtnNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setListeners();
    }

    private void initViews(){
        normalBtn = (Button) findViewById(R.id.btn_normal);
        exitBtn = (Button) findViewById(R.id.btn_exit);
        successBtn = (Button) findViewById(R.id.btn_success);
        successConfirmBtn = (Button) findViewById(R.id.btn_success_confirm);
        errorBtn = (Button) findViewById(R.id.btn_error);
        errorConfirmBtn = (Button) findViewById(R.id.btn_error_confirm);
        progressBtn = (Button) findViewById(R.id.btn_progress);
        customEnterBtn = (Button) findViewById(R.id.btn_input_type);
        imageBtn = (Button) findViewById(R.id.btn_image_type);

        normalBtnNew = (Button) findViewById(R.id.btn_normal_new);
        exitBtnNew = (Button) findViewById(R.id.btn_exit_new);
        successBtnNew = (Button) findViewById(R.id.btn_success_new);
        successConfirmBtnNew = (Button) findViewById(R.id.btn_success_confirm_new);
        errorBtnNew = (Button) findViewById(R.id.btn_error_new);
        errorConfirmBtnNew = (Button) findViewById(R.id.btn_error_confirm_new);
        progressBtnNew = (Button) findViewById(R.id.btn_progress_new);
        customEnterBtnNew = (Button) findViewById(R.id.btn_input_type_new);
        imageBtnNew = (Button) findViewById(R.id.btn_image_type_new);
    }

    private void setListeners(){
        normalBtn.setOnClickListener(this);
        exitBtn.setOnClickListener(this);
        successBtn.setOnClickListener(this);
        successConfirmBtn.setOnClickListener(this);
        errorBtn.setOnClickListener(this);
        errorConfirmBtn.setOnClickListener(this);
        progressBtn.setOnClickListener(this);
        customEnterBtn.setOnClickListener(this);
        imageBtn.setOnClickListener(this);

        normalBtnNew.setOnClickListener(this);
        exitBtnNew.setOnClickListener(this);
        successBtnNew.setOnClickListener(this);
        successConfirmBtnNew.setOnClickListener(this);
        errorBtnNew.setOnClickListener(this);
        errorConfirmBtnNew.setOnClickListener(this);
        progressBtnNew.setOnClickListener(this);
        customEnterBtnNew.setOnClickListener(this);
        imageBtnNew.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_normal:
                DialogUtils.showNormalDialogWithConfirm(MainActivity.this, "Title", "Normal message...", 3, CustomAlertDialog.NORMAL_TYPE, false);
                break;
            case R.id.btn_exit:
                DialogUtils.showExitAppDialog(MainActivity.this, false);
                break;
            case R.id.btn_success:
                DialogUtils.showSuccMessage(MainActivity.this, "Transaction ", null, 3, false);
                break;
            case R.id.btn_success_confirm:
                DialogUtils.showSuccMessageWithConfirm(MainActivity.this, "Success message...", false);
                break;
            case R.id.btn_error:
                DialogUtils.showErrMessage(MainActivity.this, "error!", "Error message...", null, 3, false);
                break;
            case R.id.btn_error_confirm:
                DialogUtils.showErrMessageWithConfirm(MainActivity.this, "Error message...", false);
                break;
            case R.id.btn_progress:
                DialogUtils.showProcessDialog(MainActivity.this, "Title", "Message...", 3, CustomAlertDialog.PROGRESS_TYPE, false);
                break;
            case R.id.btn_input_type:
                DialogUtils.showInputTypeDialog(MainActivity.this, "Title", "This is error tips", CustomAlertDialog.CUSTOM_ENTER_TYPE, false);
                break;
            case R.id.btn_image_type:
                DialogUtils.showImageTypeDialog(MainActivity.this, "This is message content", R.mipmap.short_of_paper, false);
                break;


            case R.id.btn_normal_new:
                DialogUtils.showNormalDialogWithConfirm(MainActivity.this, "Title", "Normal message...", 3, CustomAlertDialog.NORMAL_TYPE, true);
                break;
            case R.id.btn_exit_new:
                DialogUtils.showExitAppDialog(MainActivity.this, true);
                break;
            case R.id.btn_success_new:
                DialogUtils.showSuccMessage(MainActivity.this, "Transaction ", null, 3, true);
                break;
            case R.id.btn_success_confirm_new:
                DialogUtils.showSuccMessageWithConfirm(MainActivity.this, "Success message...", true);
                break;
            case R.id.btn_error_new:
                DialogUtils.showErrMessage(MainActivity.this, "error!", getString(R.string.response_C1), null, 3, true);
                break;
            case R.id.btn_error_confirm_new:
                DialogUtils.showErrMessageWithConfirm(MainActivity.this, "Error message...", true);
                break;
            case R.id.btn_progress_new:
                DialogUtils.showProcessDialog(MainActivity.this, "Title", "Message...", 3, CustomAlertDialog.PROGRESS_TYPE, true);
                break;
            case R.id.btn_input_type_new:
                DialogUtils.showInputTypeDialog(MainActivity.this, "Title", "This is error tips", CustomAlertDialog.CUSTOM_ENTER_TYPE, true);
                break;
            case R.id.btn_image_type_new:
                DialogUtils.showImageTypeDialog(MainActivity.this, getString(R.string.image_alert_type_content), R.mipmap.short_of_paper, true);
                break;


            default:
                break;
        }
    }
}
