package com.estate.real.ui;

public class ChatItemObject {

    private String title;
    private String message;
    private int photo;
    private String date;

    public ChatItemObject(String title, String message, int photo, String date) {
        this.title = title;
        this.message = message;
        this.photo = photo;
        this.date = date;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getDate(){return date;}
    public void setDate(String date){this.date = date;}
}
