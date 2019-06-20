package com.ygs.extoheal;

public class Diagnosis {
    protected int id;
    protected String title;
    private String describe;

    public Diagnosis(int id, String title, String describe) {
        this.id = id;
        this.title = title;
        this.describe = describe;
    }
    public Diagnosis(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
