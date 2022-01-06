package com.example.drtrpcarwash;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {
    protected Cursor cursor;
    Database database;
    Button btn_simpan;
    EditText nama,tipe,plat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create2);
        database = new Database(this);
        nama = findViewById(R.id.nama);
        tipe = findViewById(R.id.tipe);
        plat = findViewById(R.id.plat);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("insert into mobil(nama,tipe,plat) values('" +
                        nama.getText().toString() + "','" +
                        tipe.getText().toString() + "'," +
                        plat.getText().toString() + "')");
                Toast.makeText(CreateActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
            }
        });
    }
}