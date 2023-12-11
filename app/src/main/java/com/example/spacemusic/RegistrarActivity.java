package com.example.spacemusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrarActivity extends AppCompatActivity {
    private EditText iptCorreo, iptUsuario, iptContrasena;
    private Button btnRegistrar;
    private TextView txtInicioSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        iptCorreo = findViewById(R.id.iptCorreo);
        iptUsuario = findViewById(R.id.iptUsuario);
        iptContrasena = findViewById(R.id.iptContrasena);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        txtInicioSesion = findViewById(R.id.txtInicioSesion);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        txtInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrarActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}