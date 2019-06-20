package com.ygs.extoheal;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static DataBaseHelper dbHelper =null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseHelper dbHelp = new DataBaseHelper(this);
        SQLiteDatabase db =null;
        try {
            dbHelp.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            db = dbHelp.getWritableDatabase();
            db.close();
            if(dbHelper==null) {
                dbHelper = dbHelp;
            }
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        CardView cardView = findViewById(R.id.research_card);
        cardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.ex_card:break;
            case R.id.research_card:
                Intent intent = new Intent(MainActivity.this, ResearchActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_card:break;
        }
    }
}
