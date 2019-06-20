package com.ygs.extoheal;

public class Answer {
    private int id;
    private String describe;
    private double value;

    public Answer(int id, String describe, double value) {
        this.id = id;
        this.describe = describe;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getDescribe() {
        return describe;
    }

    public double getValue() {
        return value;
    }


    @Override
    public String toString() {
        return id+' '+describe+" val:"+value;


    }
}
