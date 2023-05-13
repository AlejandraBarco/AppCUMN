package com.example.proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class agregarMedicion extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private ImageButton icon;
    private EditText arg1,arg4,arg5,arg7,arg8,arg9,arg10,arg11,arg12,arg13,arg14,arg15,arg16;
    private Spinner arg2,arg6;
    private Button button_agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_agregarmedicion);
        icon = findViewById(R.id.menu);
        button_agregar = findViewById(R.id.button_agregar);
        arg1 = findViewById(R.id.edittext_nombre);
        arg2 = findViewById(R.id.spinner_tipo);
        arg4 = findViewById(R.id.edittext_herramienta);
        arg5 = findViewById(R.id.edittext_unidad);
        arg6 = findViewById(R.id.spinner_tamaño);
        arg7 = findViewById(R.id.edittext_codelines);
        arg8 = findViewById(R.id.edittext_sentencias);
        arg9 = findViewById(R.id.edittext_metodos);
        arg10 = findViewById(R.id.edittext_clases);
        arg11 = findViewById(R.id.edittext_codesmells);
        arg12 = findViewById(R.id.edittext_clasesconcretas);
        arg13 = findViewById(R.id.edittext_clasesabstractas);
        arg14 = findViewById(R.id.edittext_duclicatedLines);
        arg15 = findViewById(R.id.edittext_duclicatedFiles);
        arg16 = findViewById(R.id.edittext_cpu);

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(agregarMedicion.this,MeasuresActivity.class));
            }
        });
        button_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { agregar();  }
        });
    }
    private void agregar(){
        String a1,a2,a4,a5,a6;
        int a7,a8,a9,a10,a11,a12,a13,a14,a15;
        Double a16;
        a1 = arg1.getText().toString();
        a2 = arg2.getItemAtPosition(arg2.getSelectedItemPosition()).toString();
        a4 = arg4.getText().toString();
        a5 = arg5.getText().toString();
        a6 = arg6.getItemAtPosition(arg6.getSelectedItemPosition()).toString();
        a7 = Integer.parseInt(arg7.getText().toString());
        a8 = Integer.parseInt(arg8.getText().toString());
        a9 = Integer.parseInt(arg9.getText().toString());
        a10 = Integer.parseInt(arg10.getText().toString());
        a11 = Integer.parseInt(arg11.getText().toString());
        a12 = Integer.parseInt(arg12.getText().toString());
        a13 = Integer.parseInt(arg13.getText().toString());
        a14 = Integer.parseInt(arg14.getText().toString());
        a15 = Integer.parseInt(arg15.getText().toString());
        a16 = Double.parseDouble(arg16.getText().toString());


        if(TextUtils.isEmpty(a1)){
            Toast.makeText(getApplicationContext(),"Introduce un nombre válido",Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(a4)) {
            Toast.makeText(getApplicationContext(),"Introduce una herramienta válida",Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(a5)) {
            Toast.makeText(getApplicationContext(),"Introduce una unidad de medida válida",Toast.LENGTH_SHORT).show();
        }else if  (TextUtils.isEmpty(String.valueOf(a7)) || Integer.parseInt(String.valueOf(a7)) <= 0) {
            Toast.makeText(getApplicationContext(),"Introduce un valor válido para las líneas de código",Toast.LENGTH_SHORT).show();
        }else if  (TextUtils.isEmpty(String.valueOf(a8)) || Integer.parseInt(String.valueOf(a8)) <= 0) {
            Toast.makeText(getApplicationContext(),"Introduce un valor válido para las funciones",Toast.LENGTH_SHORT).show();
        }else if  (TextUtils.isEmpty(String.valueOf(a9)) || Integer.parseInt(String.valueOf(a9)) <= 0) {
            Toast.makeText(getApplicationContext(),"Introduce un valor válido para los métodos",Toast.LENGTH_SHORT).show();
        }else if  (TextUtils.isEmpty(String.valueOf(a10)) || Integer.parseInt(String.valueOf(a10)) <= 0) {
            Toast.makeText(getApplicationContext(),"Introduce un valor válido para las clases",Toast.LENGTH_SHORT).show();
        }else if  (TextUtils.isEmpty(String.valueOf(a11)) || Integer.parseInt(String.valueOf(a11)) <= 0) {
            Toast.makeText(getApplicationContext(),"Introduce un valor válido para los codesmells",Toast.LENGTH_SHORT).show();
        }

        /*Aplicacion aplicacion1 = new Aplicacion(a1,a2,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16);
        myRef.child("Usuarios").child(mAuth.getCurrentUser().getUid()).child("Aplicaciones").push().setValue(aplicacion1);*/

        String key = myRef.child("Usuarios").child(mAuth.getCurrentUser().getUid()).child("Aplicaciones").push().getKey();
        Aplicacion aplicacion1 = new Aplicacion(a1, a2, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16,key);
        myRef.child("Usuarios").child(mAuth.getCurrentUser().getUid()).child("Aplicaciones").child(key).setValue(aplicacion1);

        Toast.makeText(getApplicationContext(),"Datos enviados correctamente",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(agregarMedicion.this,MeasuresActivity.class);
        startActivity(i);
        finish();


    }

}