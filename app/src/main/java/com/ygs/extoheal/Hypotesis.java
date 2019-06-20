package com.ygs.extoheal;

import java.util.ArrayList;

public class Hypotesis extends Diagnosis implements Comparable<Hypotesis>{
    private class Observation{
        private float positive;
        private float negative;
        private float user;// оценка пользователя

        public Observation(float positive, float negative) {
            this.positive = positive;
            this.negative = negative;
        }
        public void setUser(float user){
            this.user = user;
            return ;
        }
        private float getUser(){
            return  user;
        }
        public float getNegative() {
            return negative;
        }

        public float getPositive() {
            return positive;
        }
    }
    private ArrayList <Observation> observations;
    private double possability;//априорная вероятность
    private double p=0;

    public double getP() {
        return p;
    }

    public Hypotesis(int id, String title, double possability){
        super(id,title,"");
        observations = new ArrayList<Observation>();
      //  this.title = title;
        this.possability=possability;
    }

    public void setObservations(float possabilityPositive[],float possabilityNegative[]) {
        int max =possabilityPositive.length;
        for(int i=0;i<max;i++){
            observations.add(new Observation(possabilityPositive[i],possabilityNegative[i]));

        }
    }
    public void setUserDecisions(float[] userDecisions){
        for(int i=0;i<observations.size();i++){
            observations.get(i).setUser(userDecisions[i]);
        }
    }

    public void calc(float minRate,float maxRate){
        for (Observation observ:observations) {
           float EH = observ.getPositive();
           float notEH = observ.getNegative();
           double pHE = EH*possability/((EH*possability)+(notEH*(1-possability)));
           double pNotHE = ((1-EH)*possability)*((1-EH)*possability+(1-notEH)*(1-possability));
           float q = observ.getUser();
           float pQ = (q-minRate)/(maxRate-minRate);
           float pNotQ = 1-pQ;
           double pHQ = pHE*pQ +pNotHE*pNotQ;
           p=+pHQ;
        }
        System.out.println("CalcRes:"+p+"\tid:"+id);
    }

    @Override
    public int compareTo(Hypotesis anotherH) {
        if (this.p == anotherH.p) {
            return 0;
        } else if (this.p < anotherH.p) {
            return 1;
        } else {
            return -1;
        }

    }
}
