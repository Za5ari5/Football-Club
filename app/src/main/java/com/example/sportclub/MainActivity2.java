package com.example.sportclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private Button button3;
    private EditText fname,sname,aage,eemail,usrname,passwrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
// Initialisation des Views
        fname = findViewById(R.id.fname);
        sname = findViewById(R.id.sname);
        aage = findViewById(R.id.aage);
        eemail = findViewById(R.id.eemail);
        usrname = findViewById(R.id.usrname);
        passwrd = findViewById(R.id.passwrd);
        button3 = findViewById(R.id.button3);

        //Onclicklistener pour la button Register pour enregister dans la base de donnees les informations qu'on a saisis
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            //appler la fonction addClient de la classe Mydatabasehpour qu'on peut inserer ces elements dans la base de donnees
                Mydatabaseh mydb = new Mydatabaseh(MainActivity2.this);
                mydb.addClient(fname.getText().toString().trim(), sname.getText().toString().trim(),Integer.valueOf(aage.getText().toString().trim()),
                        eemail.getText().toString().trim(),passwrd.getText().toString().trim(),
                        usrname.getText().toString().trim());
            //ouvrir lactivite de login
                Intent intent1 = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent1);

            }
        });

    }
}