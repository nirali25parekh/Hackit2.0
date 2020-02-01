package com.example.hackit20;

public class TutorialItemsModel {
    private String head, time, desc;
    private int view;

    TutorialItemsModel(){}

    public TutorialItemsModel(String head, String time, String desc, int view) {
        this.head = head;
        this.time = time;
        this.desc = desc;
        this.view = view;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}