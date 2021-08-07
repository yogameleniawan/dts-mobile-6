package com.yunhasnawa.apploginsederhana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {
    private TextView txt_username;
    private TextView txt_hari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        this.txt_username = this.findViewById(R.id.txtv_user);
        this.txt_hari = this.findViewById(R.id.txtv_hari);
        String username = getIntent().getStringExtra("username");

        this.txt_username.setText("Selamat datang, "+username+" !");
        this.txt_hari.setText("Hari ini tanggal "+currentDate);
    }

    public void logout(View view)
    {
        // Mengakhiri (menghancurkan) Activity saat ini
        this.finish();
        this.finishActivity(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_item_about){
            Intent i = new Intent(HomeActivity.this, AboutActivity.class);
            this.startActivity(i);
        }else if(id == R.id.menu_item_logout){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}