package com.example.monitory;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginCodeActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txtCheckCodeAgree)
    TextView txtAgree;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.edtInputCode)
    EditText edtInputCode;
    @SuppressLint("NonConstantResourceId")
    @BindString(R.string.check_code_warning_empty_title)
    String emptyTitle;
    @SuppressLint("NonConstantResourceId")
    @BindString(R.string.check_code_warning_empty_desc)
    String emptyMessage;
    @SuppressLint("NonConstantResourceId")
    @BindString(R.string.warning_title)
    String warningTitle;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_code);

        ButterKnife.bind(this);

        txtAgree.setText(Html.fromHtml(getString(R.string.check_code_text_agreement)));
    }

    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.btnCheckCode)
    public void masuk(View view) {
        String code = edtInputCode.getText().toString();

        //validasi jika inputan kode masih kosong
        if (isStringEmpty(code)) {
            //menampilkan dialog pesan warning
            showWarningMessage();
        } else {
            //Pindah halaman
            startActivity(new Intent(this, BiodataActivity.class));
        }
    }

    public static boolean isStringEmpty(String str) {
        return "".equals(str);
    }

    public void showWarningMessage(){
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_warning_code);
        dialog.setTitle(warningTitle);

        TextView textTitle = (TextView) dialog.findViewById(R.id.txtWarningDialogTitle);
        TextView text = (TextView) dialog.findViewById(R.id.txtWarningDialogDesc);
        Button dialogButton = (Button) dialog.findViewById(R.id.btnWarningDialogOk);

        textTitle.setText(emptyTitle);
        text.setText(emptyMessage);

        dialogButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }

}