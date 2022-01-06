package com.example.drtrpcarwash;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    protected Cursor cursor;
    Database database;
    Button btn_simpan;
    TextView nama,tipe,plat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        database = new Database(this);
        nama = findViewById(R.id.nama);
        tipe = findViewById(R.id.tipe);
        plat = findViewById(R.id.plat);
        btn_simpan = findViewById(R.id.btn_simpan);
        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM mobil WHERE nama = '" +
                getIntent().getStringExtra("nama")+"'", null);
        cursor.moveToFirst();
        if (cursor.getCount() >0){
            cursor.moveToPosition(0);
            nama.setText(cursor.getString(0).toString());
            tipe.setText(cursor.getString(1).toString());
            plat.setText(cursor.getString(2).toString());

        }
    }
}