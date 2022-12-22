package com.example.sportclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaration et initialisation des Views
    private Button button2,butto;
    private EditText usr1,passw1;
    private ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butto=findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        //la button2 pour ouvrir une activite de regisration
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "plz register",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        butto.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View view, MotionEvent motionEvent) {

                return false;
            }
        });
        /*la butto pour voir si luser et vraiment dans la base de donnees ou non, ont appelent la fonction
        usrpass() de la classe Mydatabaseh apres on ouvre la troisieme activite, cest HomePage*/
        butto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usr1 = (EditText) findViewById(R.id.usr1);
                String uss = usr1.getText().toString();
                passw1 = (EditText)findViewById(R.id.passw1);
                String pss = passw1.getText().toString();
                Mydatabaseh mydb = new Mydatabaseh(MainActivity.this);

                Boolean checkk = mydb.usrpass(uss,pss);
                if (checkk == true){

                    Intent intent = new Intent(MainActivity.this, MainActivity5.class);
                    intent.putExtra("usr", uss);
                    intent.putExtra("pass", pss);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "ghalat", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }
}