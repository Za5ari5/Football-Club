package com.example.sportclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity implements ItemClick {
    //declaration des Views et des classe qu'on a besoin
    RecyclerView rec;
    Modelc[] mylist;
    Myadabter adap;
    ImageView img;
    String uss;
    String pss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
//ramener le user and password from lactivite 1
        Intent intent = getIntent();
        uss = intent.getStringExtra("usr");
        pss = intent.getStringExtra("pass");
        rec = findViewById(R.id.rec);
        //limplementation du Model du recycler View
        mylist = new Modelc[]{
                new Modelc("Training Schedule", R.drawable.band1),
                new Modelc("Shop Equipement", R.drawable.band1),
                new Modelc("Profile", R.drawable.band1)
        };
        //initialiser ladapteur
        adap = new Myadabter(mylist);
        rec.setHasFixedSize(true);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adap);
        adap.setClick(this);


    }
/* override la methode OnCLick d'interface ItemCLick , si la postion quon a cliquer c'est 0 donc on va ouvrir le training schudele activity
si la postion quon a cliquer c'est 1 donc on va ouvrir shopping activity,
si la postion quon a cliquer c'est 2 donc on va ouvrir le Profile activity

 */
    @Override
    public void onClick(View view, int pos) {
        if(pos==0){
            Intent intent= new Intent(this,MainActivity6.class);
            startActivity(intent);
        }
        else if (pos==1){
            Intent intent= new Intent(this,MainActivity7.class);
            startActivity(intent);
        }
        else if (pos==2){
            Intent intent= new Intent(this,MainActivity3.class);
            intent.putExtra("usr", uss);
            intent.putExtra("pass", pss);
            startActivity(intent);


        }
        String s=String.valueOf(pos);
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }
}