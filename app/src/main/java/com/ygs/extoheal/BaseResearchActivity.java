package com.ygs.extoheal;

import android.app.Activity;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class BaseResearchActivity extends Activity implements View.OnClickListener {
    private BaseResearchSQL sql;

    private int questionsCount;
    private int questionIndex=1;
    private boolean isEnd=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_research_layout);
        RadioGroup radioGroup =  findViewById(R.id.variants);
        DataBaseHelper dbHelp = MainActivity.dbHelper;
        //DataBaseHelper dbHelp = new DataBaseHelper(this);
        try {
            dbHelp.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            SQLiteDatabase db = dbHelp.getWritableDatabase();
            sql = new BaseResearchSQL(db);

            ArrayList<Answer> questions = sql.getAnswerByGroup(0);
            for(Answer question:questions){
                Log.d("SQL_REQ",question.toString());
                RadioButton rb = new RadioButton(this);
                rb.setText(question.getDescribe());
                rb.setId(questionIndex);
                questionIndex++;
                radioGroup.addView(rb);
            }
            questionIndex=1;
            questionsCount= sql.getQuestionsCount();
            updateQuestionCard();
           // db.close();

        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        Button button= findViewById(R.id.button);
        button.setOnClickListener(this);

    }
     private void updateQuestionCard(){

            Question question = sql.getQuestionById(questionIndex);
            TextView tv = findViewById(R.id.quest_count);
            tv.setText("Питання:" + questionIndex + "/" + questionsCount);
            tv = findViewById(R.id.quest_title);
            tv.setText(question.getTitle());
            tv = findViewById(R.id.quest_descript);
            tv.setText(question.getDescription());
            questionIndex++;
            if(questionIndex==questionsCount);
    }
    @Override
    public void onClick(View v) {
        final int id = v.getId();
        switch (id){
            case R.id.button:
                if(!isEnd) {
                    updateQuestionCard();
                    RadioGroup radioGroup = findViewById(R.id.variants);
                    int rbID= radioGroup.getCheckedRadioButtonId();
                    Log.d("Radio button pressed",""+rbID);
                }
                else ((Button)v).setText(getResources().getString(R.string.end));
            break;
        }
    }

    @Override
    protected void onDestroy() {
        sql.close();
        super.onDestroy();
    }
}
