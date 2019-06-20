package com.ygs.extoheal;

import android.database.Cursor;

import java.util.ArrayList;

import android.database.sqlite.SQLiteDatabase;

public class BaseResearchSQL {

    private  SQLiteDatabase db;
    public BaseResearchSQL(SQLiteDatabase db){
        this.db = db;

    }
    public  void close(){
        db.close();
    }
    public int getQuestionsCount(){
        Cursor cursor = db.rawQuery("select count(*) as questNum from questions;",null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        cursor.close();
        return count;
    }
    public Question getQuestionById(int id){
        Cursor cursor = db.rawQuery("SELECT * FROM questions WHERE id=?;",new String[]{id+""});
        final int idIndex=  cursor.getColumnIndexOrThrow("id");
        final int desIndex =cursor.getColumnIndexOrThrow("describe");
        final int titleIndex = cursor.getColumnIndexOrThrow("title");
        final int groupIndex = cursor.getColumnIndexOrThrow("answer_group_id");

        cursor.moveToFirst();
            int idDB = cursor.getInt(idIndex);
            String text =  cursor.getString(desIndex);
            String title  = cursor.getString(titleIndex);
            int groupID = cursor.getInt(groupIndex);
        cursor.close();
        return new  Question(title,id,groupID,text);
    }
    public ArrayList <Answer>getAnswerByGroup(int groupID){

        Cursor cursor = db.rawQuery("SELECT * FROM anserw_variants WHERE question_group=?;",new String[]{groupID+""});
        final int idIndex=  cursor.getColumnIndexOrThrow("id");
        final int desIndex =cursor.getColumnIndexOrThrow("describe");
        final int valueIndex = cursor.getColumnIndexOrThrow("value");
        ArrayList answers = new ArrayList<Answer>();
        cursor.moveToFirst();
        do{
            int id = cursor.getInt(idIndex);
            String text =  cursor.getString(desIndex);
            double val = cursor.getDouble(valueIndex);
            answers.add(new Answer(id,text,val));
        }
        while(cursor.moveToNext());
        cursor.close();
        return answers;
    }
    public void setUserAnswer(int answerID,int questionID ){

        db.execSQL("INSERT INTO anserws(question_id,variant_id) VALUES(?,?)",new String[]{""+questionID,""+answerID});
    }
}
