package com.example.sportclub;

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

public class MainActivity6 extends AppCompatActivity {
    //declaration des Views et des classe qu'on a besoin
    RecyclerView rec;
    ModelT[] mylist;
    BrAdapter adap;
    ImageView img;
    String uss;
    String pss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Intent intent = getIntent();
        uss = intent.getStringExtra("usr");
        pss = intent.getStringExtra("pass");
        rec = findViewById(R.id.rec);


        //limplementation du Model du recycler View
        mylist = new ModelT[]{
                new ModelT("Day 1\n15min"," Shoot","Curve\nStyle", R.drawable.shoot),
                new ModelT("Day 1\n15min"," Shoot","Power\nStyle", R.drawable.shoot),
                new ModelT("Day 1\n15min"," Pass","Short\nPass", R.drawable.pass),
                new ModelT("Day 1\n15min"," Pass","Long\nPass", R.drawable.pass),
                new ModelT("Day 2\n20min","Tactical\n(Squad)","Attack\nScenario", R.drawable.tactical),
                new ModelT("Day 2\n20min","Tactical\n(Squad)","Pressing\nScenario", R.drawable.tactical),
                new ModelT("Day 2\n20min","Tactical\n(Squad)","Build-up\nScenario", R.drawable.tactical),
                new ModelT("Day 2\n20min","Tactical\n(Squad)","Denfence\nScenario", R.drawable.tactical),
                new ModelT("Day 3\n15min"," Shoot","Trivela\nStyle", R.drawable.shoot),
                new ModelT("Day 3\n15min"," Shoot","Knuckle\nStyle", R.drawable.shoot),
                new ModelT("Day 3\n25min"," Tackle","Slide\nTackle", R.drawable.tackle),
                new ModelT("Day 3\n25min"," Dribble","Keep\nthe ball", R.drawable.tackle),
                new ModelT("Day 4\n20min","Tactical\n(Solo)","Positioning", R.drawable.tactical),
                new ModelT("Day 4\n20min","Tactical\n(Solo)","Surveillance", R.drawable.tactical),
                new ModelT("Day 4\n20min","Tactical\n(Solo)","Ball\nRequest", R.drawable.tactical),
                new ModelT("Day 4\n20min","Tactical\n(Solo)","Set Pieces", R.drawable.tactical),


        };
        //initialiser ladapteur
        adap = new BrAdapter(mylist);
        rec.setHasFixedSize(true);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adap);



    }

}