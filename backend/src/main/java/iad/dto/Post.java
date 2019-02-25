package iad.dto;

import java.util.Date;

public class Post {
    public Clansman clansman;
    public Date datePosted;
    public String text;

    public Post(){

    }

    public Post(Clansman clansman, Date datePosted, String text){
        this.clansman = clansman;
        this.datePosted = datePosted;
        this. text = text;
    }

    public Post(String username, long imageId, Date datePosted, String text){
        this.clansman = new Clansman(username, imageId);
        this.datePosted = datePosted;
        this. text = text;
    }
}
