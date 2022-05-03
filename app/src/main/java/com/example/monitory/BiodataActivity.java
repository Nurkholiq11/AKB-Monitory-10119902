package com.example.monitory;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BiodataActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.edtBiodataName)
    EditText edtNama;
    @SuppressLint("NonConstantResourceId")
    @BindString(R.string.check_code_warning_empty_title_name)
    String emptyTitle;
    @SuppressLint("NonConstantResourceId")
    @BindString(R.string.check_code_warning_empty_desc_name)
    String emptyMessage;
    @SuppressLint("NonConstantResourceId")
    @BindString(R.string.warning_title)
    String warningTitle;

    final Context context = this;

    public static final String ID_EXTRA_MSG = "com.example.monitory";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodota);
        ButterKnife.bind(this);
    }

    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.btnBiodataNext)

    void selanjutnya() {
        String nameBiodata = edtNama.getText().toString();
        if (isStringEmpty(nameBiodata)) {
            showWarningMessage();
        } else {
            Intent intent = new Intent(this, DoneActivity.class);
            intent.putExtra(ID_EXTRA_MSG, nameBiodata);
            startActivity(intent);
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
        TextView textDesc = (TextView) dialog.findViewById(R.id.txtWarningDialogDesc);
        Button dialogButton = (Button) dialog.findViewById(R.id.btnWarningDialogOk);

        textTitle.setText(emptyTitle);
        textDesc.setText(emptyMessage);

        dialogButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}