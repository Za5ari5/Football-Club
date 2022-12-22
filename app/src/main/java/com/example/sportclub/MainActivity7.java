package com.example.sportclub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {
    RecyclerView rec;
    ModelS[] mylist;
    SpAdapter adap;
    ImageView img;
    String uss;
    String pss;
    LinearLayoutManager ln;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Intent intent = getIntent();
        uss = intent.getStringExtra("usr");
        pss = intent.getStringExtra("pass");


        rec = findViewById(R.id.rec);
        //limplementation du Model du recycler View

        mylist = new ModelS[]{
                new ModelS("PREDATOR","250$", R.drawable.predator),
                new ModelS("Adidas Ball","100$", R.drawable.alrihla),
                new ModelS("PREDATOR","70$", R.drawable.predgloves),
                new ModelS("UCL Ball","150$", R.drawable.adidas2020),
                new ModelS("Neymar Shirt","200$", R.drawable.neymar),
                new ModelS("Morocco Shirt","75$", R.drawable.morocco),
                new ModelS("Brazil Shirt","75$", R.drawable.brazil),
                new ModelS("NEMSIS","200$", R.drawable.nemziz),
                new ModelS("UHL Gloves","25$", R.drawable.uhl),
                new ModelS("Adidas Ball","170$", R.drawable.alhilm),
                new ModelS("Juventus Jersey","130$", R.drawable.juventus),
                new ModelS("PHANTOM","200$", R.drawable.phantom),
                new ModelS("Tracksuit","40$", R.drawable.tracksuit),
                new ModelS("Algeria Jacket","200$", R.drawable.algeria),
                new ModelS("Inter Jersey","90$", R.drawable.inter),
                new ModelS("UCL Ball","100$", R.drawable.adidas2021),


        };
        //initialiser ladapteur pour que le recycler View soit horizontal
        ln = new LinearLayoutManager(MainActivity7.this, LinearLayoutManager.HORIZONTAL,false);
        adap = new SpAdapter(mylist);
        rec.setHasFixedSize(true);
        rec.setLayoutManager(ln);
        rec.setAdapter(adap);



    }

}