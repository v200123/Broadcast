package com.example.lc.broadcast.another_view;

public class issue_collection {
    public int getIssue_number() {
        return issue_number;
    }

    public void setIssue_number(int issue_number) {
        this.issue_number = issue_number;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }


    private  int  issue_number;
            private  String     mQuestion;

    public Boolean getAnswer() {
        return mAnswer;
    }

    public void setAnswer(Boolean answer) {
        mAnswer = answer;
    }

    private  Boolean    mAnswer;
}
