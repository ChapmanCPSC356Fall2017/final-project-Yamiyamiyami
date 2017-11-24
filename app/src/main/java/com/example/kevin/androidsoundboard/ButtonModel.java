package com.example.kevin.androidsoundboard;

import java.util.UUID;

/**
 * Created by kevin on 11/23/2017.
 */

public class ButtonModel  {
    private String id;
    private String text;
    public ButtonModel(){
        this.id = UUID.randomUUID().toString();
    }
    public String getID(){
        return id;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return text;
    }

}
