package com.responsiRehan.responsiFintech;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.responsiRehan.responsiFintech.historyrecyclerview.Distro;
import com.responsiRehan.responsiFintech.historyrecyclerview.DistroAdapter;
import com.responsiRehan.responsiFintech.historyrecyclerview.DistroData;
import com.responsiRehan.responsiFintech.menu.AccountActivity;
import com.responsiRehan.responsiFintech.menu.HistoryActivity;
import com.responsiRehan.responsiFintech.menu.PaymentActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.appbar,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.openProfile:
                startActivity(new Intent(MainActivity.this, AccountActivity.class));

                return true;

        }
        return false;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);

        RecyclerView recyclerView = findViewById(R.id.rv_data);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Distro> distros = new ArrayList<>();
        distros.addAll(DistroData.getDatas());
        DistroAdapter distroAdapter = new DistroAdapter(distros);
        recyclerView.setAdapter(distroAdapter);


        // Pindah halaman button di home fragment
        ImageButton btnPay = findViewById(R.id.btnPay);
        ImageButton btnHistory = findViewById(R.id.btnHistory);
        ImageButton btnAccount = findViewById(R.id.btnAccount);
//        ImageButton btnProfile = findViewById(R.id.btnProfile);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perintah Intent Explicit untuk berpindah ke SecondActivity
                startActivity(new Intent(MainActivity.this, PaymentActivity.class));
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perintah Intent Explicit untuk berpindah ke SecondActivity
                startActivity(new Intent(MainActivity.this, HistoryActivity.class));
            }
        });
//
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perintah Intent Explicit untuk berpindah ke SecondActivity
                startActivity(new Intent(MainActivity.this, AccountActivity.class));
            }
        });

//        btnProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Perintah Intent Explicit untuk berpindah ke SecondActivity
//                startActivity(new Intent(MainActivity.this, AccountActivity.class));
//            }
//        });

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_payment, R.id.navigation_history)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if (result.getContents() == null){
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Hasil Scan");
                alertDialog.setMessage("Anda membatalkan scanning");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YA",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }else {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Hasil Scan");
                alertDialog.setMessage(result.toString());
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YA",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

}