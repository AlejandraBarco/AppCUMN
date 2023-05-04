package com.example.proyect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MeasuresActivity extends AppCompatActivity {
        //implements         AdapterView.OnItemClickListener{
    private ImageButton icon;
    private FloatingActionButton plus;
   // public static final String[] names = new String[] { "Alonso Quijano",
     //       "Dulcinea del Toboso", "Sancho Panza", "Rocinante", "Clavileño" };
    //private ListView listView;
    private RecyclerView recyclerView;
    private List<Aplicacion> apps;
    private Adapter adapter;
   // List<RowItem> rowItems;
   // private ArrayAdapter<RowItem> adapter;

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

       /* rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < names.length; i++) {
            RowItem item = new RowItem(names[i]);
            rowItems.add(item);
        }

       listView = (ListView) findViewById(R.id.listView);
        RowArrayAdapter adapter = new RowArrayAdapter(this,
              R.layout.row_item, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);*/

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        apps = new ArrayList<>();
        //FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference();
        DatabaseReference databaseReference2 = databaseReference1.child("Aplicaciones");


        adapter = new Adapter(apps);
        recyclerView.setAdapter(adapter);
        //database.getReference().child("Aplicaciones").addValueEventListener(new ValueEventListener() {
        databaseReference2.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //apps.removeAll(apps);
               //Gson gson = new Gson();
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    //Aplicacion app = snapshot.getValue(Aplicacion.class);
                    //apps.add(app);

                    //String nombre = ds.child("nombre").getValue(String.class);
                    //String elemento = ds.child("elemento").getValue(String.class);
                    //Log.d("TAG", nombre + " / " + elemento);
                    Aplicacion app = ds.getValue(Aplicacion.class);
                    apps.add(app);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

   /* @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (position + 1) + ": " + rowItems.get(position),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }*/
}