package com.example.proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserActivity extends AppCompatActivity {
    private ImageButton icon;

    private Button buttonMisMediciones, buttonTodasMediciones, buttonPerfil,buttonGreenDeveloper,buttonPrecios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        icon = findViewById(R.id.icon);
        buttonMisMediciones =findViewById(R.id.button2);
        buttonTodasMediciones =findViewById(R.id.button4);
        buttonPerfil = findViewById(R.id.button5);
        buttonGreenDeveloper = findViewById(R.id.button3);
        buttonPrecios = findViewById(R.id.button);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this,Perfil.class));
            }
        });
        buttonMisMediciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this,AppActivity.class));
            }
        });
        buttonTodasMediciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this,MeasuresActivity.class));
            }
        });
        buttonPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this,Perfil.class));
            }
        });
        buttonGreenDeveloper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this,GreenDeveloper.class));
            }
        });
        buttonPrecios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this,PruebaPrecios.class));
            }
        });
    }

}