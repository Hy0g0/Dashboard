package com.example.application.data.widget.mywidgets;

import java.time.LocalDate;

import com.example.application.data.widget.Widget;

import com.vaadin.flow.component.html.H1;

import com.vaadin.flow.component.html.H2;

public class CalendrierWidget extends Widget {

    public CalendrierWidget() {
        super();
        LocalDate myObj = LocalDate.now(); // Create a date object

        l.add(new H2(""+myObj.getMonth().toString()));
        l.add(new H1(""+myObj.getDayOfMonth()));
        l.add(new H2(""+myObj.getDayOfWeek().toString()));
        l.setId("Calendar");
    }
    @Override
    public void refresh(){
        LocalDate myObj = LocalDate.now();
        H2 t1 = (H2)l.getChildren().toArray()[0];
        t1.setText(""+myObj.getMonth().toString());
        H1 t = (H1)l.getChildren().toArray()[1];
        t.setText(""+myObj.getDayOfMonth());
        H2 t2 = (H2)l.getChildren().toArray()[2];
        t2.setText(""+myObj.getDayOfWeek().toString());
    }

}
