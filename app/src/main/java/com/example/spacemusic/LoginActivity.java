package com.example.spacemusic;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText iptUsuario, iptContrasena;
    private Button btnIniciarsesion, btnCancelar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iptUsuario = findViewById(R.id.iptUsuario);
        iptContrasena = findViewById(R.id.iptContrasena);
        btnIniciarsesion = findViewById(R.id.btnIniciarsesion);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnIniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}