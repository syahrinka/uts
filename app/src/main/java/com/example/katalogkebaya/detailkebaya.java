package com.example.katalogkebaya;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.katalogkebaya.models.databasekatalog;

public class detailkebaya extends AppCompatActivity {

    String id;
    databasekatalog db;
    String jeniskebaya, modelkebaya, deskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailkebaya);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        jeniskebaya = intent.getStringExtra("jeniskebaya");
        modelkebaya = intent.getStringExtra("modelkebaya");
        deskripsi = intent.getStringExtra("deskripsi");

        TextView text_jeniskebayad= (TextView) findViewById(R.id.text_jeniskebaya);
        TextView text_modelkebayad= (TextView) findViewById(R.id.text_modelkebaya);
        TextView text_deskripsid = (TextView) findViewById(R.id.text_deskripsi);
        ImageButton update = (ImageButton) findViewById(R.id.update);
        ImageButton hapus = (ImageButton) findViewById(R.id.hapus);


        text_jeniskebayad.setText("Jenis Kebaya : " + jeniskebaya);
        text_modelkebayad.setText("Model Kebaya :" +  modelkebaya);
        text_deskripsid.setText("Deskripsi : " + deskripsi);

        db = new databasekatalog (this);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = detailkebaya.this;
                Intent i = new Intent(context, updatekebaya.class);
                i.putExtra("jeniskebaya", jeniskebaya);
                i.putExtra("modelkebaya", modelkebaya);
                i.putExtra("deskripsi", deskripsi);
                context.startActivity(i);
                finish();
            }
        });

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase dbsql = db.getReadableDatabase();
                dbsql.delete("notekatalogkebaya","jeniskebaya = '" + jeniskebaya + "'",null);
                Toast.makeText(detailkebaya.this,"Berhasil dihapus!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
