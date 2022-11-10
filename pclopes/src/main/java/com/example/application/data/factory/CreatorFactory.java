package com.example.application.data.factory;

import java.util.ArrayList;
import java.util.List;

import com.example.application.data.widget.WidgetCreator;
import com.example.application.data.widget.WidgetEnum;
import com.vaadin.flow.component.html.Image;

public class CreatorFactory {

    public CreatorFactory(){
    }

    public List<WidgetCreator> create(){
    List<WidgetCreator> creator = new ArrayList<WidgetCreator>();
    WidgetEnum[] possibleValues = WidgetEnum.class.getEnumConstants();
    for(WidgetEnum value : possibleValues){
        creator.add(new WidgetCreator(getImage(value),value.name(),value));
    }
    return creator;
     }
    public Image getImage(WidgetEnum w){
        switch(w){
            case TWITTER:
                return new Image("images/twitter.png", "placeholder plant");
            case METEO:
                return new Image("images/meteo.png", "meteo");
            case REDDIT:
                return new Image("images/Reddit.png", "reddit");
            case CALENDRIER:
                return new Image("images/callendrier.png", "placeholder plant");
            case CALCULTETTE:
                return new Image("images/calculette.png", "placeholder plant");
            case HORLOGE :
                return new Image("images/Horloge.png", "placeholder plant");
            case JOKE :
                return new Image("images/Joke.png", "placeholder plant");
            default:
                return  new Image("images/empty-plant.png", "placeholder plant");
        }
        }
    }
