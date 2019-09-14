package com.example.foxfirekeep.models;

public class Forums{

    private int forums_id;
    private String forumsName;
    private String forumsRole;
    private String forumsComment;


    public Forums(int forums_id, String forumsName, String forumsRole, String forumsComment){

        this.forums_id = forums_id;
        this.forumsName = forumsName;
        this.forumsRole = forumsRole;;
        this.forumsComment = forumsComment;

    }

    public int getForums_id() {
        return forums_id;
    }

    public String getForumsName() {
        return forumsName;
    }

    public String getForumsRole() {
        return forumsRole;
    }

    public String getForumsComment() {
        return forumsComment;
    }
}
