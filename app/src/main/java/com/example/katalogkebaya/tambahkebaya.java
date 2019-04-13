package com.example.katalogkebaya;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.katalogkebaya.models.databasekatalog;

public class tambahkebaya extends AppCompatActivity {

    EditText text_jeniskebaya,text_modelkebaya,text_deskripsi;
    ImageButton button_save;
    databasekatalog db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahkebaya);

        db = new databasekatalog(this);

        text_jeniskebaya = (EditText) findViewById(R.id.text_jeniskebaya);
        text_modelkebaya = (EditText) findViewById(R.id.text_modelkebaya);
        text_deskripsi = (EditText) findViewById(R.id.text_deskripsi);
        button_save = (ImageButton) findViewById(R.id.button_save);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                SQLiteDatabase dbnya = db.getWritableDatabase();
                String jeniskebaya = text_jeniskebaya.getText().toString();
                String modelkebaya = text_modelkebaya.getText().toString();
                String deskripsi = text_deskripsi.getText().toString();


                String sql = "INSERT INTO notekatalogkebaya(jeniskebaya, modelkebaya, deskripsi) values('"+jeniskebaya+"','"+modelkebaya+"','"+deskripsi+"')";
//                dbnya.execSQL("insert into notekatalogkebaya(jeniskebaya, modelkebaya, deskripsi) values('" + text_jeniskebaya.getText().toString() + "','" + text_modelkebaya.getText().toString() + "','" + text_deskripsi.getText().toString() + "')");
                try {
                    dbnya.execSQL(sql);
                    Toast.makeText(getApplicationContext(), "BERHASIL DITAMBAH!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(tambahkebaya.this, daftarkatalogkebaya.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "GAGAL DITAMBAH!", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

}

