package com.example.learninghtmlandcssapp;

import java.io.Serializable;

public class Courses implements Serializable {
    // PROPERTIES
    private int  lessonNumber;
    private String NameOfLesson;
    private String LengthOfVideo;
    private boolean CheckStatus;
    private String Description;
    private String Notes;
    private String link;


    public Courses(int lessonNumber, String nameOfLesson, String lengthOfVideo, boolean checkStatus, String description, String notes,String link) {
        this.lessonNumber = lessonNumber;
        NameOfLesson = nameOfLesson;
        LengthOfVideo = lengthOfVideo;
        CheckStatus = checkStatus;
        Description = description;
        Notes = notes;
        this.link = link;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }


    public String getNameOfLesson() {
        return NameOfLesson;
    }


    public String getLengthOfVideo() {
        return LengthOfVideo;
    }


    public boolean isCheckStatus() {
        return CheckStatus;
    }

    public void setCheckStatus(boolean checkStatus) {
        CheckStatus = checkStatus;
    }

    public String getDescription() {
        return Description;
    }



    public String getLink() { return link;
    }



    @Override
    public String toString() {
        return "Courses{" +
                "lessonNumber=" + lessonNumber +
                ", NameOfLesson='" + NameOfLesson + '\'' +
                ", LengthOfVideo='" + LengthOfVideo + '\'' +
                ", CheckStatus=" + CheckStatus +
                ", Description='" + Description + '\'' +
                ", Notes='" + Notes + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
