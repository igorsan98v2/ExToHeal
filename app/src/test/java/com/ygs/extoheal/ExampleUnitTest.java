package com.ygs.extoheal;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void es_isPerfect(){
        ExpertSystem expertSystem = new ExpertSystem();
        float [] positive1= new float[23];
        float [] negative1 = new float[23];
        float [] positive2= new float[23];
        float [] negative2 = new float[23];
        float [] positive3= new float[23];
        float [] negative3 = new float[23];
        float [] user = new float[23];
        for(int i=0;i<23;i++){
            positive1[i]=0.2f;
            negative1[i]=0.5f;

            positive2[i]=0.2f;
            negative2[i]=0.5f;

            positive3[i]=0.2f;
            negative3[i]=0.5f;
            user[i] = -5;
            if(i==18){
                positive1[i]=1f;
                negative1[i]=0;

                positive2[i]=1f;
                negative2[i]=0f;

                positive3[i]=1f;
                negative3[i]=0f;
                user[i]=5;
            }
            if(i==20){

                positive1[i]=1f;
                negative1[i]=0f;



            }
            if(i==21){
                positive2[i]=1f;
                negative2[i]=0f;
            }
            if(i==22){
                positive3[i]=1f;
                negative3[i]=0f;
                user[i]=5;
            }

        }
        expertSystem.addHypotesis(0,"Вагітність I триместр",positive1,negative1);
        expertSystem.addHypotesis(1,"Вагітність II триместр",positive2,negative2);
        expertSystem.addHypotesis(2,"Вагітність III триместр",positive3,negative3);

        expertSystem.addUserDecisions(user,0);
        expertSystem.addUserDecisions(user,1);
        expertSystem.addUserDecisions(user,2);
        assertEquals(2,expertSystem.calcHypotesis(-5f,5f).getId());
    }
}