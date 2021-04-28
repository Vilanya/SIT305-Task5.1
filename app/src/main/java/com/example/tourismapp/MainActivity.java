package com.example.tourismapp;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements com.example.tourismapp.VerticalAdapter.OnRowClickListener{
    RecyclerView recyclerViewHorizontal;
    HorizontalAdapter horizontalAdapter;
    List<Horizontal> HorizontalList = new ArrayList<>();
    Integer[] imageListH = {R.drawable.colombo, R.drawable.hikkaduwa, R.drawable.kandy, R.drawable.nuwaraeliya, R.drawable.sigiriya, R.drawable.yala};

    RecyclerView recyclerViewVertical;
    VerticalAdapter verticalAdapter;
    List<Vertical> VerticalList = new ArrayList<>();

    Integer[] imageList = {R.drawable.colombo, R.drawable.hikkaduwa, R.drawable.kandy, R.drawable.nuwaraeliya, R.drawable.sigiriya, R.drawable.yala};
    String[] nameList = {"Colombo","Hikkaduwa","Kandy","Nuwara Eliya","Sigiriya","Yala"};
    String[] descripList = {"Colombo is considered to be the heart of Sri Lanka, located next to the Galle Face beach, with several 5-star hotels in the vicinity.",
        "Hikkaduwa is located near the ocean. It is a very popular destination for tourists and even Sri Lankans during the holiday season.",
        "Kandy is home to several national monuments. The tooth relic of Lord Buddha is located in the Temple of the Sacred Tooth Relic, which is in Kandy, Sri Lanka.",
        "Nuwara Eliya is home to a large number of tea plantations. You can see tea growing everywhere in Nuwara Eliya, Sri Lanka. Tourists are welcome to take pictures, but trespassing is not allowed.",
        "Sigiriya in Sri Lanka is famous for its palace ruins on top of a massive rock. The rock itself is a lava plug left over from an ancient long extinct volcano.",
        "Yala is home to one of the biggest national parks in Sri Lanka. it is the most visited national park in Sri Lanka and tourists can enjoy the view on safari rides."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewHorizontal = findViewById(R.id.horizontalView);
        horizontalAdapter = new HorizontalAdapter(HorizontalList, this);
        recyclerViewHorizontal.setAdapter(horizontalAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewHorizontal.setLayoutManager(layoutManager);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        for (int i = 0; i < imageListH.length; i++){
            com.example.tourismapp.Horizontal horizontal = new com.example.tourismapp.Horizontal(i, imageListH[i]);
            HorizontalList.add(horizontal);
        }

        recyclerViewVertical = findViewById(R.id.verticalView);
        verticalAdapter = new VerticalAdapter(VerticalList, MainActivity.this.getApplicationContext(), this);
        recyclerViewVertical.setAdapter(verticalAdapter);
        recyclerViewVertical.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < imageList.length; i++){
            com.example.tourismapp.Vertical vertical = new com.example.tourismapp.Vertical(i,imageList[i],nameList[i],descripList[i]);
            VerticalList.add(vertical);
        }
    }

    @Override
    public void onItemClick(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                fragment = new Fragment1();
                break;
            case 1:
                fragment = new Fragment2();
                break;
            case 2:
                fragment = new Fragment3();
                break;
            case 3:
                fragment = new Fragment4();
                break;
            case 4:
                fragment = new Fragment5();
                break;
            case 5:
                fragment = new Fragment6();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment).commit();
    }
}
