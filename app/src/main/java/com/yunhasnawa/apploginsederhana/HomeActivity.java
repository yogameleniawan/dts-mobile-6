package com.yunhasnawa.apploginsederhana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    private TextView txt_username;
    private TextView txt_hari;
    private ArrayList<String> data;
    private ListView listView;
    private String[] listData = {"Mengerjakan tugas mobile", "Mengerjakan tugas web", "Mengerjakan tugas desain", "Mengerjakan tugas phyton"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        this.txt_username = this.findViewById(R.id.txtv_user);
        this.txt_hari = this.findViewById(R.id.txtv_hari);
        this.listView = this.findViewById(R.id.list_item);
        data = new ArrayList<>();
        getData();
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.list_view, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        String username = getIntent().getStringExtra("username");

        this.txt_username.setText("Selamat datang, "+username+" !");
        this.txt_hari.setText("Hari ini tanggal "+currentDate);
    }

    private void getData() {
        Collections.addAll(data, listData);
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

    @Override
    public void onItemClick(AdapterView adapterView, View view, int position, long l) {
        String getData = data.get(position);
        Toast.makeText(this,getData,Toast.LENGTH_SHORT).show();
    }
}