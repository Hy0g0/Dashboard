package com.example.application.data.factory;

import com.example.application.data.widget.Widget;
import com.example.application.data.widget.WidgetEnum;
import com.example.application.data.widget.mywidgets.CalculetteWidget;
import com.example.application.data.widget.mywidgets.CalendrierWidget;
import com.example.application.data.widget.mywidgets.HorlogeWidget;
import com.example.application.data.widget.mywidgets.MeteoWidget;
import com.example.application.data.widget.mywidgets.RedditWidget;
import com.example.application.data.widget.mywidgets.TwitterWidget;
import com.example.application.data.widget.mywidgets.JokeWidget;

public class WidgetFactory {

    public WidgetFactory() {

    }

    public Widget create(WidgetEnum WidgetEnum) {
        switch (WidgetEnum) {
            case TWITTER:
                return new TwitterWidget();
            case METEO:
                return new MeteoWidget();
            case REDDIT:
                return new RedditWidget();
            case CALENDRIER:
                return new CalendrierWidget();
            case CALCULTETTE:
                return new CalculetteWidget();
            case HORLOGE:
                return new HorlogeWidget();
            case JOKE:
                return new JokeWidget();
            default:
                return null;
        }

    }
}
