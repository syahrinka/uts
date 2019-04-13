package com.example.katalogkebaya;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class noteadapter extends RecyclerView.Adapter<noteadapter.NoteAdapterViewHolder>{

    private ArrayList<notekatalogkebaya> notekatalogkebaya;

    public noteadapter(ArrayList<notekatalogkebaya> list) {
        this.notekatalogkebaya = list;
    }

    @Override
    public NoteAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.daftaritem, parent, false);
        return new NoteAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteAdapterViewHolder holder, final int position) {
        holder.text_jeniskebaya.setText(notekatalogkebaya.get(position).getJeniskebaya());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pindahKeNoteDetail(position, v.getContext());
            }
        });
    }

    private void pindahKeNoteDetail(int position, Context c) {
        Context context = c;
        Intent i = new Intent(context, detailkebaya.class);
        i.putExtra("jeniskebaya", notekatalogkebaya.get(position).getJeniskebaya());
        i.putExtra("modelkebaya", notekatalogkebaya.get(position).getModelkebaya());
        i.putExtra("deskripsi", notekatalogkebaya.get(position).getDeskripsi());
        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return (notekatalogkebaya != null) ? notekatalogkebaya.size() : 0;
    }

    public class NoteAdapterViewHolder extends RecyclerView.ViewHolder{
        private TextView text_jeniskebaya,tfNomor;

        public NoteAdapterViewHolder(View itemView) {
            super(itemView);
            text_jeniskebaya = (TextView) itemView.findViewById(R.id.text_jeniskebaya);
        }
    }

}