package com.example.proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class agregarMedicion extends AppCompatActivity {
    private ImageButton icon;
    private EditText arg1,arg4,arg5,arg7,arg8,arg9,arg10,arg11,arg12,arg13;
    private Spinner arg2,arg6;
    private Button button_agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregarmedicion);
        icon = findViewById(R.id.menu);
        button_agregar = findViewById(R.id.button_agregar);
        arg1 = findViewById(R.id.edittext_nombre);
        arg2 = findViewById(R.id.spinner_tipo);
        arg4 = findViewById(R.id.edittext_herramienta);
        arg5 = findViewById(R.id.edittext_unidad);
        arg6 = findViewById(R.id.spinner_tamaño);
        arg7 = findViewById(R.id.edittext_codelines);
        arg8 = findViewById(R.id.edittext_funciones);
        arg9 = findViewById(R.id.edittext_metodos);
        arg10 = findViewById(R.id.edittext_clases);
        arg11 = findViewById(R.id.edittext_codesmells);
        arg12 = findViewById(R.id.edittext_clasesconcretas);
        arg13 = findViewById(R.id.edittext_clasesabstractas);

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(agregarMedicion.this,AppActivity.class));
            }
        });
        button_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { agregar();  }
        });
    }
    private void agregar(){
        String a1,a2,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13;
        a1 = arg1.getText().toString();
        //hay que mirar que posicion o como se obtiene el string de la spinner getSelectedItemposition??
        a2 = arg2.getItemAtPosition(0).toString();
        a4 = arg4.getText().toString();
        a5 = arg5.getText().toString();
        a6 = arg6.getItemAtPosition(0).toString();
        a7 = arg7.getText().toString();
        a8 = arg8.getText().toString();
        a9 = arg9.getText().toString();
        a10 = arg10.getText().toString();
        a11 = arg11.getText().toString();
        a12 = arg12.getText().toString();
        a13 = arg13.getText().toString();
    }

}