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
import android.widget.TextView;
import android.widget.Toast;

        import com.google.android.material.floatingactionbutton.FloatingActionButton;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;
        import com.google.gson.Gson;

        import java.util.ArrayList;
        import java.util.List;

public class MeasuresActivitySingular extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private ImageButton icon;
    private FloatingActionButton plus;
    private RecyclerView recyclerView;
    private List<Aplicacion> apps;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measures_singular);
        icon = findViewById(R.id.icon);
        plus = findViewById(R.id.plus);
        mAuth = FirebaseAuth.getInstance();

        Bundle extras = getIntent().getExtras();
        String appKey = extras.getString("AppKey");
        Toast.makeText(getApplicationContext(), "La clave de la aplicación es: " + appKey, Toast.LENGTH_LONG).show();


        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MeasuresActivitySingular.this,AppActivity.class));
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MeasuresActivitySingular.this, agregarMedicion.class));
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        apps = new ArrayList<>();

        String id = mAuth.getCurrentUser().getUid();
        //String appId = "-NUwHDf0Fqa8KNRIWbn1";
        DatabaseReference databaseReference =FirebaseDatabase.getInstance().getReference().child("Usuarios").child(id).child("Aplicaciones").child(appKey);


        adapter = new Adapter(apps);
        recyclerView.setAdapter(adapter);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    apps.removeAll(apps);
                        Aplicacion app = dataSnapshot.getValue(Aplicacion.class);
                        apps.add(app);
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}