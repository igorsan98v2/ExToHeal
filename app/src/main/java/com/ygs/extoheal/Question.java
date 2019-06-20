package com.ygs.extoheal;

public class Question {
    private String title;
    private int id;
    private int answerGroupId;
    private String description;

    public Question(String title, int id, int answerGroupId, String description) {
        this.title = title;
        this.id = id;
        this.answerGroupId = answerGroupId;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getAnswerGroupId() {
        return answerGroupId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
