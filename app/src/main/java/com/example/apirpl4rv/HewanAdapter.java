package com.example.apirpl4rv;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HewanAdapter extends RecyclerView.Adapter<HewanAdapter.HewanHolder> {
    Activity activity;
    List<Hewan> daftarHewannya;

    public HewanAdapter(Activity activity, List<Hewan> daftarHewannya) {
        this.activity = activity;
        this.daftarHewannya = daftarHewannya;
    }

    @NonNull
    @Override
    public HewanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.hewan_item,parent,false);
        return new HewanHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HewanHolder holder, int position) {
        holder.txtFamily.setText(daftarHewannya.get(position).getFamily());
        holder.txtJenis.setText(daftarHewannya.get(position).getJenis());
    }

    @Override
    public int getItemCount() {
        return daftarHewannya.size();
    }

    static class HewanHolder extends RecyclerView.ViewHolder {
        TextView txtFamily,txtJenis;
        public HewanHolder(@NonNull View itemView) {
            super(itemView);
            txtFamily=(TextView) itemView.findViewById(R.id.txt_family);
            txtJenis=(TextView) itemView.findViewById(R.id.txt_jenis);
        }
    }
}
