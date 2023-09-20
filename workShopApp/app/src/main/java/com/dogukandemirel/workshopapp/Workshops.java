package com.dogukandemirel.workshopapp;

public class Workshops {
    String heading;
    int titleImage;
    String emailAddress;
    String emailSubject;
    String emailContent;

    public Workshops(String heading, int titleImage, String emailAddress, String emailSubject, String emailContent) {
        this.heading = heading;
        this.titleImage = titleImage;
        this.emailAddress = emailAddress;
        this.emailSubject = emailSubject;
        this.emailContent = emailContent;
    }

    public String getHeading() {
        return heading;
    }

    public int getTitleImage() {
        return titleImage;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public String getEmailContent() {
        return emailContent;
    }
}

