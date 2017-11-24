package com.example.kevin.androidsoundboard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 11/23/2017.
 */

public class buttonlist {
    private static buttonlist list;

    public static buttonlist GetInstance(){
        if(list==null){
            list = new buttonlist();
        }
        return list;
    }
    private List<ButtonModel> buttons;
    private buttonlist(){
        this.buttons = new ArrayList<>();
        ButtonModel button1 = new ButtonModel();
        ButtonModel button2 = new ButtonModel();
        ButtonModel button3 = new ButtonModel();
        ButtonModel button4 = new ButtonModel();
        ButtonModel button5 = new ButtonModel();
        ButtonModel button6 = new ButtonModel();
        ButtonModel button7 = new ButtonModel();
        ButtonModel button8 = new ButtonModel();
        ButtonModel button9 = new ButtonModel();
        ButtonModel button10 = new ButtonModel();
        button1.setText("Meow");
        button2.setText("Moo");
        button3.setText("Quack");
        button4.setText("Rawr");
        button5.setText("Woof");
        button6.setText("Hee-Haw");
        button7.setText("Chirp");
        button8.setText("Oink");
        button9.setText("Baa");
        button10.setText("Hoot");
        this.buttons.add(button1);
        this.buttons.add(button2);
        this.buttons.add(button3);
        this.buttons.add(button4);
        this.buttons.add(button5);
        this.buttons.add(button6);
        this.buttons.add(button7);
        this.buttons.add(button8);
        this.buttons.add(button9);
        this.buttons.add(button10);
    }
    public List<ButtonModel> getButtons(){return this.buttons; }
    public ButtonModel getButton(String id){
        for (ButtonModel button: this.buttons)
        {
            if (button.getID().equals(id)){
                return button;
            }
        }
        return null;
    }
}
