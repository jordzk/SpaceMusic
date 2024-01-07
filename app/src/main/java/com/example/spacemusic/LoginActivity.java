package com.example.spacemusic;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    private EditText iptUsuario, iptContrasena;
    private Button btnIniciarsesion, btnCancelar;

    FirebaseAuth auth;


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
                String email = iptUsuario.getText().toString().trim();
                String password = iptContrasena.getText().toString().trim();

                if (!email.isEmpty() && !password.isEmpty()) {
                    // Autenticar con Firebase
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Inicio de sesión exitoso
                                        Intent intent = new Intent(LoginActivity.this, InicioActivity.class);
                                        startActivity(intent);
                                        finish();  // Esto evita que el usuario vuelva atrás con el botón de retroceso
                                    } else {
                                        // Si el inicio de sesión falla, muestra un mensaje al usuario
                                        Toast.makeText(LoginActivity.this, "Error en el inicio de sesión", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    // Si el correo electrónico o la contraseña están vacíos, muestra un mensaje
                    Toast.makeText(LoginActivity.this, "Por favor, ingresa correo y contraseña", Toast.LENGTH_SHORT).show();
                }
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