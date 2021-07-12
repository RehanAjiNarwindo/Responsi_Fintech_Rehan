package com.responsiRehan.responsiFintech.historyrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.responsiRehan.responsiFintech.R;

import java.util.ArrayList;

public class DistroAdapter extends RecyclerView.Adapter<DistroAdapter.ViewHolder>{
    private ArrayList<Distro> distros ;

    public DistroAdapter(ArrayList<Distro> distros) {
        this.distros = distros;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaksi, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Distro distro = distros.get(position);
        holder.tvName.setText(distro.getName());
        holder.tvInfo.setText(distro.getInfo());
        holder.ivLogo.setText(distro.getLogo());
    }

    @Override
    public int getItemCount() {
        return distros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvInfo, ivLogo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvInfo = itemView.findViewById(R.id.tv_info);
            ivLogo = itemView.findViewById(R.id.iv_logo);
        }
    }
}