package com.responsiRehan.responsiFintech.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.ArrayList;




import android.content.Context;

import android.widget.Toast;

import java.util.List;

import com.responsiRehan.responsiFintech.R;
import com.responsiRehan.responsiFintech.homerecyclerview.GridMarginDecoration;
import com.responsiRehan.responsiFintech.homerecyclerview.Home;
import com.responsiRehan.responsiFintech.homerecyclerview.HomeListAdapter;

/**
 * Created by wim on 4/14/16.
 */
public class HomeFragment extends Fragment implements HomeListAdapter.OnGridItemSelectedListener{

    private RecyclerView lvSingle;
    private GridLayoutManager gridLayoutManager;
    private HomeListAdapter homeListAdapter;
    private Context context;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        lvSingle = (RecyclerView) rootView.findViewById(R.id.rv_data);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        homeListAdapter = new HomeListAdapter(this);
        // grid 2 kolom
        gridLayoutManager = new GridLayoutManager(context, 2);
        lvSingle.setLayoutManager(gridLayoutManager);

        // set margin 2 dp
        lvSingle.addItemDecoration(new GridMarginDecoration(context, 2, 2, 2, 2));
        lvSingle.setAdapter(homeListAdapter);
        loadData();
    }

    private void loadData(){
        List<Home> singleList = new ArrayList<>();
        Home single;
        int img[] = {R.drawable.headset1, R.drawable.headset2,
                R.drawable.headset1, R.drawable.headset2,
                R.drawable.headset1, R.drawable.headset2,
                R.drawable.headset1, R.drawable.headset2, R.drawable.headset1, R.drawable.headset2};
        String title[] = {"headset", "headset",
                "headset", "headset",
                "headset", "headset",
                "Headset", "Headset", "headset", "headset"};
        String pengarang[] = {"Rp.20.000", "Rp.30.000",
                "Rp.40.000", "Rp.80.000",
                "Rp.60.000", "Rp.70.000",
                "Rp.65.000", "Rp.55.000", "Rp.79.000", "Rp.45.000"};
        for (int i = 0; i < img.length; i++){
            single = new Home();
            single.setImg(img[i]);
            single.setTitle(title[i]);
            single.setPengarang(pengarang[i]);
            singleList.add(single);
        }
        homeListAdapter.addAll(singleList);
    }

    @Override
    public void onGridItemClick(View v, int position) {
        Toast.makeText(context, homeListAdapter.getItem(position).getTitle(), Toast.LENGTH_SHORT).show();
    }

}