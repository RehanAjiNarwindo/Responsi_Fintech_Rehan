package com.responsiRehan.responsiFintech.homerecyclerview;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.responsiRehan.responsiFintech.R;

import java.util.ArrayList;
import java.util.List;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.HomeViewHolder>{

    private List<Home> homeList;
    private OnGridItemSelectedListener onGridItemSelectedListener;

    public HomeListAdapter(OnGridItemSelectedListener onGridItemSelectedListener) {
        this.onGridItemSelectedListener = onGridItemSelectedListener;
        homeList = new ArrayList<>();
    }

    private void add(Home item) {
        homeList.add(item);
        notifyItemInserted(homeList.size() - 1);
    }

    public void addAll(List<Home> homeList) {
        for (Home home : homeList) {
            add(home);
        }
    }

    public void remove(Home item) {
        int position = homeList.indexOf(item);
        if (position > -1) {
            homeList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public Home getItem(int position){
        return homeList.get(position);
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        final HomeViewHolder HomeViewHolder = new HomeViewHolder(view);
        HomeViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPos = HomeViewHolder.getAdapterPosition();
                if (adapterPos != RecyclerView.NO_POSITION) {
                    if (onGridItemSelectedListener != null) {
                        onGridItemSelectedListener.onGridItemClick(HomeViewHolder.itemView, adapterPos);
                    }
                }
            }
        });
        return HomeViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        final Home home = homeList.get(position);
        holder.img.setImageResource(home.getImg());
        holder.title.setText(home.getTitle());
        holder.pengarang.setText(home.getPengarang());
    }

    @Override
    public int getItemCount() {
        return homeList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        TextView pengarang;
        public HomeViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.iv_logo);
            title = (TextView) itemView.findViewById(R.id.tv_name);
            pengarang = (TextView) itemView.findViewById(R.id.tv_info);
        }
    }

    public interface OnGridItemSelectedListener {
        void onGridItemClick(View v, int position);
    }
}
