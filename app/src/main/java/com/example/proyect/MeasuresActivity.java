package com.example.proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MeasuresActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ImageButton icon;
    private FloatingActionButton plus;
    public static final String[] names = new String[] { "Alonso Quijano",
            "Dulcinea del Toboso", "Sancho Panza", "Rocinante", "Clavileño" };
    private ListView listView;
    List<RowItem> rowItems;
    private ArrayAdapter<RowItem> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measures);
        icon = findViewById(R.id.icon);
        plus = findViewById(R.id.plus);

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MeasuresActivity.this,UserActivity.class));
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MeasuresActivity.this, agregarMedicion.class));
            }
        });

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < names.length; i++) {
            RowItem item = new RowItem(names[i]);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.listView);
        RowArrayAdapter adapter = new RowArrayAdapter(this,
                R.layout.row_item, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (position + 1) + ": " + rowItems.get(position),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}