package com.project.sepon.informationproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by SEPOn on 8/30/2016.
 */
public class Database extends SQLiteOpenHelper {

    public static Database instance = null;

    public static String KEY_DATABASE_NAME = "DATABASE";
    public static String KEY_DATABASE_TABLE_NAME = "PERSON_INFORMATION";
    public static int KEY_DATABASE_VERSION = 001;


    public static String KEY_PERSON_ID = "";
    public static String KEY_PERSON_NAME = "_NAME";
    public static String KEY_PERSON_FATHER_NAEM = "_FATHER_NAEM";
    public static String KEY_PERSON_EDUCATION = "_EDUCATION";
    public static String KEY_PERSON_PROFFESION = "_PROFFESION";
    public static String KEY_PERSON_NUMBER = "_NUMBER";
    public static String KEY_PERSON_ADDRESS = "_ADDRESS";
    public static String KEY_PERSON_EMAIL = "EMAIL";


    //database designe in singleturn petarn_________________________
    public static Database getinstance(Context context) {

        if (instance == null) {
            instance = new Database(context);
        }

        return instance;
    }

    //__SQL QUARY
    private String sql_quary= "CREATE TABLE "+KEY_DATABASE_TABLE_NAME +"( "
            + KEY_PERSON_NAME +" TEXT ,"
            + KEY_PERSON_FATHER_NAEM +" TEXT ,"
            + KEY_PERSON_EDUCATION +" TEXT ,"
            + KEY_PERSON_PROFFESION +" TEXT ,"
            + KEY_PERSON_NUMBER +" TEXT ,"
            + KEY_PERSON_EMAIL +" TEXT ,"
            + KEY_PERSON_ADDRESS +" TEXT "+ ");";


    public Database(Context context) {
        super(context, KEY_DATABASE_NAME, null, KEY_DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sql_quary);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //	insert data in database......................................

    public long insertData(Personinformation personinformation){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_PERSON_NAME, personinformation.getPersonName());
        values.put(KEY_PERSON_FATHER_NAEM, personinformation.getFatherName());
        values.put(KEY_PERSON_PROFFESION, personinformation.getOcupation());
        values.put(KEY_PERSON_EDUCATION, personinformation.getEducation());
        values.put(KEY_PERSON_ADDRESS, personinformation.getLocation());
        values.put(KEY_PERSON_NUMBER, personinformation.getMobile());
        values.put(KEY_PERSON_EMAIL, personinformation.getEmail());

        long insert = db.insert(KEY_DATABASE_TABLE_NAME, null, values);

        return insert;
    }

//    show all data in listview
public ArrayList<Personinformation> getallinformation() {
    ArrayList<Personinformation> templist = new ArrayList<Personinformation>();
    SQLiteDatabase db = this.getReadableDatabase();
    String quarey = "SELECT * FROM "+KEY_DATABASE_TABLE_NAME +";";

    Cursor dcursor = db.rawQuery(quarey, null);

    if (dcursor != null && dcursor.getCount()>0) {
        dcursor.moveToFirst();

        for (int i = 0; i < dcursor.getCount(); i++) {


            String personName = dcursor.getString(dcursor.getColumnIndex(KEY_PERSON_NAME));
            String personFatherName = dcursor.getString(dcursor.getColumnIndex(KEY_PERSON_FATHER_NAEM));
            String personEducation = dcursor.getString(dcursor.getColumnIndex(KEY_PERSON_EDUCATION));
            String personProffesion = dcursor.getString(dcursor.getColumnIndex(KEY_PERSON_PROFFESION));
            String personAddress = dcursor.getString(dcursor.getColumnIndex(KEY_PERSON_ADDRESS));
            String personMobileNumber = dcursor.getString(dcursor.getColumnIndex(KEY_PERSON_NUMBER));
            String personEmail = dcursor.getString(dcursor.getColumnIndex(KEY_PERSON_EMAIL));


            Personinformation personinformation = new Personinformation(personName, personFatherName,
                    personEducation,personProffesion,personAddress,personMobileNumber,personEmail);


            templist.add(personinformation);
            dcursor.moveToNext();

        }

        if (dcursor != null) {
            dcursor.close();
            db.close();
        }

    }

    return templist;
}
}
