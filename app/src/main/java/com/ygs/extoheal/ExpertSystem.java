package com.ygs.extoheal;

import android.graphics.YuvImage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ExpertSystem {
    private int hypothesisNum;
    private int observationNum;
    private ArrayList <Hypotesis> hypoteses;

    public ExpertSystem(int hypothesisNum, int observationNum) {
        double hypPosabillity=0.0;
        this.hypothesisNum = hypothesisNum;
        this.observationNum = observationNum;
        Hypotesis [] hypotesis = new Hypotesis[hypothesisNum];
        //float []afterPregancyPositive = {0.0f,0.0f,0.f,0.f};
        //float []afterPregancyNegative = {0.0f,0.0}

    }
    public ExpertSystem(){
        hypoteses = new ArrayList<>();
    }
    public void addHypotesis(int id,String title,float[] positives,float[] negatives){
        Hypotesis hypotesis =new Hypotesis(id,title,0.5);
        hypotesis.setObservations(positives,negatives);
        hypoteses.add(id,hypotesis);

    }
    public void addUserDecisions(float[] userDecision,int hypId){
        hypoteses.get(hypId).setUserDecisions(userDecision);
    }
    public Hypotesis calcHypotesis(float minRate,float maxRate){
        for (int i=0;i<hypoteses.size();i++){
            hypoteses.get(i).calc(minRate,maxRate);
        }
        Collections.sort(hypoteses);
        return hypoteses.get(0);
    }

}
