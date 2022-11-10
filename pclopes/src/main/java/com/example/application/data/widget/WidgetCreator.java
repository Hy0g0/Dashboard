package com.example.application.data.widget;

import javax.persistence.EnumType;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;

public class WidgetCreator extends Div{
    
    protected Div l;
    private WidgetEnum type;
    public WidgetEnum getType() {
        return type;
    }


    public Div getL() {
            return l;
        }
    
    
    /**
     * Construct a new Widget
     */
    public WidgetCreator(Image image,String str,WidgetEnum type){
        l = new Div();
        this.type = type;
        l.add(new H1(str));
        l.add(image); 
        l.setId(str);
        l.addClassName("Creator");
    }

}
