package com.example.monitory;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoneActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txtDoneTitle)
    TextView txtNama;
    @SuppressLint("NonConstantResourceId")
    @BindString(R.string.activation_beres)
    String beres;
    @SuppressLint("NonConstantResourceId")
    @BindString(R.string.activation_sudah_bisa)
    String sudahBisa;
    @SuppressLint("NonConstantResourceId")
    @BindString(R.string.activation_setiap)
    String setiap;
    @SuppressLint("NonConstantResourceId")
    @BindString(R.string.activation_buat)
    String buat;

    public static final String ID_EXTRA_MSG_EXIT = "com.example.monitory";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        ButterKnife.bind(this);
        bindExtra();
    }

    @SuppressLint("SetTextI18n")
    private void bindExtra(){
        Intent intent = getIntent();
        String name = intent.getStringExtra(BiodataActivity.ID_EXTRA_MSG);
        txtNama.setText(beres+" "+ name +" "+sudahBisa+" "+ name +" "+setiap+" "+ name +" "+buat);
    }

    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.btnDoneNext)
    public void selesai(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(ID_EXTRA_MSG_EXIT, true);
        startActivity(intent);
    }

}