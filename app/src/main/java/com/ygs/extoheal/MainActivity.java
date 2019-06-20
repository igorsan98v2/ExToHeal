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
        cardView = findViewById(R.id.ex_card);
        cardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        Intent intent = null;
        switch (id){
            case R.id.ex_card:
                intent = new Intent(MainActivity.this, ArCameraActivity.class);
                startActivity(intent);
                break;
            case R.id.research_card:
                 intent = new Intent(MainActivity.this, ResearchActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_card:break;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();

        //Operations to apply for Camera privileges
        
        try {
            session = new Session(/* context= */ this);
            session.resume();
        } catch (CameraNotAvailableException e) {
            // In some cases, Camera is being used by other App s. In this case, Camera Not Available exception may be reported
            session = null;
            return;
        }

        surfaceView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (session != null) {
            // Note: The order can't be changed! GLSurfaceView must be suspended first, otherwise GLSurfaceView will continue to call Session's update method.
            // However, Session is in a pause state, so the Session PausedException exception is reported.
            surfaceView.onPause();
            session.pause();
        }
    }
}
