package com.example.katalogkebaya;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.katalogkebaya.models.databasekatalog;

import java.util.ArrayList;

public class daftarkatalogkebaya extends AppCompatActivity {
    RecyclerView recyclerView;
    noteadapter adapter;
    ArrayList<notekatalogkebaya> notekatalogkebaya;
    databasekatalog db;
    Cursor cursor;
    TextView tvNote;
    ImageButton plus;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarkatalogkebaya);

        db = new databasekatalog(this);

        SharedPreferences spUser = daftarkatalogkebaya.this.getSharedPreferences("Userlogin", Context.MODE_PRIVATE);
        String namaSedangLogin = spUser.getString("sedangLogin", "Defaultnya Manusia");

        TextView text = (TextView) findViewById(R.id.userlogin);
        TextView rv_notes = (TextView) findViewById(R.id.rv_notes);

        text.setText("LOGIN SEBAGAI : " + namaSedangLogin);

        recyclerView = (RecyclerView) findViewById(R.id.rv_notes);
        tvNote = (TextView) findViewById(R.id.tvNote);
        plus = (ImageButton) findViewById(R.id.plus);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(daftarkatalogkebaya.this, tambahkebaya.class);
                startActivity(intent);
                finish();
            }
        });

        addDataDummy();

    }

    @Override
    protected void onResume() {
        super.onResume();
        addDataDummy();
    }

    private void addDataDummy() {
        notekatalogkebaya = new ArrayList<>();
        SQLiteDatabase dbsql = db.getReadableDatabase();
        cursor = dbsql.rawQuery("SELECT * FROM notekatalogkebaya", null);
        cursor.moveToFirst();

        if (cursor.getCount() > 0) {
            do {

                notekatalogkebaya.add(new notekatalogkebaya(cursor.getString(cursor.getColumnIndex("jeniskebaya")), cursor.getString(cursor.getColumnIndex("modelkebaya")), cursor.getString(cursor.getColumnIndex("deskripsi"))));

            } while (cursor.moveToNext());
        }

        adapter = new noteadapter(notekatalogkebaya);

        layoutManager = new LinearLayoutManager(daftarkatalogkebaya.this);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(layoutManager);

        if(notekatalogkebaya.size() > 0) {
            this.tvNote.setText("JUMLAH KATALOG KEBAYA : " + notekatalogkebaya.size());
        }else {
            adapter.notifyDataSetChanged();
            this.tvNote.setText("TIDAK ADA KATALOG YANG DITAMPILKAN : ");
        }
    }
}
