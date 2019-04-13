package com.example.katalogkebaya;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.katalogkebaya.models.databasekatalog;

public class updatekebaya extends AppCompatActivity {

        EditText text_jeniskebaya, text_modelkebaya, text_deskripsi;
        ImageButton button_saveupdate;
        databasekatalog db;
        Cursor cursor;
        String jeniskebaya, modelkebaya, deskripsi;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_updatekebaya);

            Intent intent = getIntent();
            jeniskebaya = intent.getStringExtra("jeniskebaya");
            modelkebaya = intent.getStringExtra("modelkebaya");
            deskripsi  = intent.getStringExtra("deskripsi");

            text_jeniskebaya = (EditText) findViewById(R.id.text_jeniskebayaupdate);
            text_modelkebaya = (EditText) findViewById(R.id.text_modelkebayaupdate);
            text_deskripsi = (EditText) findViewById(R.id.text_deskripsiupdate);

            button_saveupdate = (ImageButton) findViewById(R.id.button_saveupdate);

            text_jeniskebaya.setText(jeniskebaya);
            text_modelkebaya.setText(modelkebaya);
            text_deskripsi.setText(deskripsi);
            db = new databasekatalog(this);

            button_saveupdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SQLiteDatabase dbnya = db.getWritableDatabase();
                    dbnya.execSQL("update notekatalogkebaya set jeniskebaya='"+ text_jeniskebaya.getText() +"', modelkebaya='"+ text_modelkebaya.getText() +"', deskripsi='"+ text_deskripsi.getText() +"' where jeniskebaya='"+ jeniskebaya +"'");
                    finish();
                    Toast.makeText(updatekebaya.this,"BERHASIL DI UPDATE",Toast.LENGTH_LONG).show();
                }
            });
        }
    }

