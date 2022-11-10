package com.example.application.data.widget.mywidgets;

import java.time.LocalTime;

import com.example.application.data.widget.Widget;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;

public class HorlogeWidget extends Widget {
    private int count = 0;
    H1 h1 ;
    public HorlogeWidget() {
        super();
        LocalTime myObj = LocalTime.now(); // Create a date object

        l.add(new H2(""));
        h1 = new H1("" + myObj.getHour() + ":" + myObj.getMinute() + ":" + myObj.getSecond());
        l.add(h1);
        l.add(new H2(""));
        l.setId("Calendar");
    }

    @Override
    public void refresh() {
        System.out.println("It's time a clock" + count);
        count++;
        LocalTime myObj = LocalTime.now();
        h1.setText("" + myObj.getHour() + ":" + myObj.getMinute() + ":" + myObj.getSecond());
    }
}
