package com.example.hoteligoadmin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String title, address, description, price, city;
    EditText e1, ci, e2, e3, e4;
    Button b1;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference Ref = database.getReference("cities");



        e1 = findViewById(R.id.name);
        e2 = findViewById(R.id.address);
        e3 = findViewById(R.id.details);
        e4 = findViewById(R.id.price);
        ci = findViewById(R.id.city);

        b1 = findViewById(R.id.btn_submit);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = e1.getText().toString();
                address = e2.getText().toString();
                description = e3.getText().toString();
                price = e4.getText().toString();
                city = ci.getText().toString();
                city = city.toUpperCase();

                Detail temp = new Detail(title, address, description, price);
                myRef = Ref.child(city);
                myRef.child(title).setValue(temp);
                Toast.makeText(MainActivity.this, "Submitted",Toast.LENGTH_SHORT).show();
            }
        });
    }
}