package com.example.sportclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    //lactivite de profile
    private TextView txt,txt1,txt2,txt3;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initialiser les Views
        String uss;
        String pss;
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        uss = intent.getStringExtra("usr");
        pss = intent.getStringExtra("pass");
        txt = findViewById(R.id.txt);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);

//appler la methode show pour selectioner la ligne des donnes precis et la mettre dans un curseur
                Mydatabaseh mydb = new Mydatabaseh(MainActivity3.this);
                Cursor res = mydb.showw(uss,pss);
                if(res.getCount()==0){
                    Toast.makeText(MainActivity3.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                //stringbuffer cest une classe qui nous permet denregister des string from curseur
                StringBuffer buffer1 = new StringBuffer();
                StringBuffer buffer2 = new StringBuffer();
                StringBuffer buffer3 = new StringBuffer();
                StringBuffer buffer4 = new StringBuffer();


// loop pour enregister les element dans le string buffer from curseur row by row
        while(res.moveToNext()) {


                    buffer1.append(res.getString(1) + " " + res.getString(2));



                    buffer2.append(res.getString(3) + " Years old");
                    int x = Integer.parseInt(res.getString(3));
                    buffer3.append(res.getString(4));
                    // condition de lage pour savoir quelle categorie
                    if (x<9){
                        buffer4.append("Poucet Category");
                    }
                    else if (x>8 && x<12){
                        buffer4.append("Poussin Category");
                    }
                    else if (x>11 && x<15){
                        buffer4.append("Minime Category");
                    }
                    else if (x>14 && x<18){
                        buffer4.append("Cadette Category");
                    }
                    else if (x>17 && x<21){
                        buffer4.append("Junior Category");
                    }
                    else if (x>20 && x<50){
                        buffer4.append("Senior Category");
                    }
//mettre les donner enregister dans les Views de notre layout
            txt.setText(buffer1.toString());
            txt1.setText(buffer2.toString());
            txt2.setText(buffer3.toString());
            txt3.setText(buffer4.toString());


        }
                b = findViewById(R.id.button4);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentt = new Intent(MainActivity3.this,MainActivity5.class);
                        startActivity(intentt);
                    }
                });









    }
}