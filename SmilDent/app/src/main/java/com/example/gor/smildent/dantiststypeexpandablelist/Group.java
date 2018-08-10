package com.example.grigor.fivefriendsmile.dantiststypeexpandablelist;

public class Group {
    private String title;
    private int doctorimage;



    public Group(String title,int doctorimage) {
        this.title = title;
        this.doctorimage = doctorimage;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDoctorimage() {
        return doctorimage;
    }

    public void setDoctorimage(int doctorimage) {
        this.doctorimage = doctorimage;
    }
}
