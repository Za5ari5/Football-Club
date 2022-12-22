package com.example.sportclub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.Console;

class Mydatabaseh extends SQLiteOpenHelper {
    //initaliser les noms qu on a besoin dans la base donnees
    private Context context;
    private static final String DATABASE_NAME = "Clientt.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "mytable";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_FIRSTNAME = "firstn";
    private static final String COLUMN_SECONDNAME = "secondn";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "passwrd";
    private static final String COLUMN_USERNAME = "usrname";

    public Mydatabaseh(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
//implementer les deux methode on create pour creer la table on upgrade

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FIRSTNAME + " TEXT, " +
                COLUMN_SECONDNAME + " TEXT, " + COLUMN_AGE + " INTEGER, " +
                COLUMN_EMAIL + " TEXT, " + COLUMN_PASSWORD + " TEXT, " + COLUMN_USERNAME + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
//la methode addClient pour inserer ce que luser a enregistrer dans la base de donnees
    void addClient(String firstn, String secondn, int age, String email, String passwrd, String usrname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_FIRSTNAME, firstn);
        cv.put(COLUMN_SECONDNAME, secondn);
        cv.put(COLUMN_AGE, age);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_PASSWORD, passwrd);
        cv.put(COLUMN_USERNAME, usrname);

        long rs = db.insert(TABLE_NAME, null, cv);
        if (rs == -1) {
            Toast.makeText(context, "failed", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "success", Toast.LENGTH_LONG).show();
        }

    }
    //la methode userpass pour voir si luser est dans notre table ou nn

    public boolean usrpass(String usrnamee, String passwrdd) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_NAME + " where " + COLUMN_USERNAME +
                " = ? and " + COLUMN_PASSWORD + " = ?", new String[]{usrnamee, passwrdd});

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }
    //la methode show pour afficher la lignes de notre user

    public Cursor showw(String usr, String pass) {

            SQLiteDatabase DB = this.getWritableDatabase();
            Cursor cursor = DB.rawQuery("Select * from mytable where "+ COLUMN_USERNAME +" = ? and "
                    + COLUMN_PASSWORD + " = ?", new String[]{usr, pass});
            return cursor;

    }

    }
