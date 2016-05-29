package com.example.b_corporation.ptanugerahgenerasibersama.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.b_corporation.ptanugerahgenerasibersama.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayKaryawan(View view){
        startActivity(new Intent(this, ProfilKaryawan.class));
    }

    public void displayPerusahaan(View view){
        startActivity(new Intent(this, ProfilPerusahaan.class));
    }

    public void displayPilihProyek(View view){
        startActivity(new Intent(this, PilihTampilProyek.class));
    }

    public void displayContact(View view){
        startActivity(new Intent(this, ContactUs.class));
    }

    public void displayBantuan(View view){
        startActivity(new Intent(this, Bantuan.class));
    }

    public void displayNilai(View view){
        startActivity(new Intent(this, HistoryProyek.class));
    }

    public void displayProyek(View view){
        startActivity(new Intent(this, HistoryProyek.class));
    }
}
