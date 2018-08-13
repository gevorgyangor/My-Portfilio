package com.example.gor.taskforjob.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ContactList {

    @SerializedName("contacts")
    @Expose
    private ArrayList<Content> contacts = new ArrayList<>();

    public ArrayList<Content> getContacts() {
        return contacts;
    }


    public void setContacts(ArrayList<Content> contacts) {
        this.contacts = contacts;
    }
}