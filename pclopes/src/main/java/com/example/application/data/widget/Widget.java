package com.example.application.data.widget;

import com.vaadin.flow.component.html.Div;

public abstract class Widget extends Div{
    
    protected Div l;
    
public Div getL() {
        return l;
    }


/**
 * Construct a new Widget
 */
public Widget(){
    l = new Div();
    l.setClassName("Widget");
}
    public void refresh(){

    }
}
