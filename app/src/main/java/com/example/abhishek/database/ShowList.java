package com.example.abhishek.database;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

/**
 * Created by Abhishek on 27-07-2016.
 */
public class ShowList extends Activity {
     ListView listView;
     TextView Name;
    CardView cardView;
     TextView FatherName;
     TextView MotherName;
     SimpleCursorAdapter adapter;
     Cursor newcr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        listView = (ListView) findViewById(R.id.listView);
        cardView=(CardView)findViewById(R.id.card_view);
        FatherName = (TextView) findViewById(R.id.father_name);
        Name = (TextView) findViewById(R.id.name);
        MotherName = (TextView) findViewById(R.id.mother_name);
        DataBase obj=new DataBase(getApplication());
        newcr= new DataBase(getApplicationContext()).sendcursor();
        loadDatabase(newcr);

    }
    private  void loadDatabase(Cursor c) {
        c.moveToFirst();
        c.moveToNext();
        String s=c.getString(0);
        String s1=c.getString(1);
        String s2=c.getString(2);
        String s3=c.getString(3);
        adapter = new SimpleCursorAdapter(this, R.layout.card_view, c, new String[]{Constants.NAME,Constants.FATHER_NAME,Constants.MOTHER_NAME}, new int[]{R.id.name,R.id.father_name,R.id.mother_name});///*,R.id.father_name,R.id.mother_name*/};
        listView.setAdapter(adapter);


    }
}
