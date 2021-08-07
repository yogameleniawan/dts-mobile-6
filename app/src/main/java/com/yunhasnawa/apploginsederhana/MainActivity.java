package com.yunhasnawa.apploginsederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    // Panggil komponen dari layout, untuk dijadikan variabel pada class ini
    // Siapkan dulu variabelnya
    private Button btnRegister;
    private Button btnLogin;
    private EditText edtUsername;
    private EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kita hubungkan button yang ada di layout dengan variabel di atas
        // findViewById()
        this.btnRegister = this.findViewById(R.id.btn_register);
        this.btnLogin = this.findViewById(R.id.btn_login);
        this.edtUsername = this.findViewById(R.id.edt_username);
        this.edtPassword = this.findViewById(R.id.edt_password);

    }

    public void login(View view)
    {
        Toast.makeText(this, "Login berhasil..", Toast.LENGTH_LONG).show();

        // Gunakan Intent untuk berpindah dari Activity satu ke Activity yang lain.
        Intent i = new Intent(MainActivity.this, HomeActivity.class);
        i.putExtra("username", this.edtUsername.getText().toString());
        this.startActivity(i);
        this.edtUsername.setText("");
        this.edtPassword.setText("");
    }

    public void register(View view)
    {
        Intent i = new Intent(MainActivity.this, RegisterActivity.class);
        this.startActivity(i);
    }
}