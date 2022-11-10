package com.example.application.data.widget.mywidgets;

import com.example.application.data.widget.Widget;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;

public class CalculetteWidget extends Widget {
    private String fieldValue = "42";
    private String saveValue = "";
    private String operation = "";
    public CalculetteWidget() {
        super();
        TextField t = new TextField();
        l.setId("Calculator");
        l.add(t);
        
        t.setReadOnly(true);
        Div container = new Div();
        Div operators = new Div();
        Div chiffres = new Div();
        Div d2 = new Div();
        d2.add(new Button("7", event -> {fieldValue+=7;t.setValue(""+fieldValue);}));
        d2.add(new Button("8", event -> {fieldValue+=8;t.setValue(""+fieldValue);}));
        d2.add(new Button("9", event -> {fieldValue+=9;t.setValue(""+fieldValue);}));
        chiffres.add(d2);
        Div d3 = new Div();
        d3.add(new Button("4", event -> {fieldValue+=4;t.setValue(""+fieldValue);}));
        d3.add(new Button("5", event -> {fieldValue+=5;t.setValue(""+fieldValue);}));
        d3.add(new Button("6", event -> {fieldValue+=6;t.setValue(""+fieldValue);}));
        chiffres.add(d3);
        Div d4 = new Div();
        d4.add(new Button("1", event -> {fieldValue+=1;t.setValue(""+fieldValue);}));
        d4.add(new Button("2", event -> {fieldValue+=2;t.setValue(""+fieldValue);}));
        d4.add(new Button("3", event -> {fieldValue+=3;t.setValue(""+fieldValue);}));
        chiffres.add(d4);
        Div d8 = new Div();
        d8.add(new Button("0", event -> {fieldValue+=0;t.setValue(""+fieldValue);}));
        chiffres.add(d8);
        Div d5 = new Div();
        d5.add(new Button("+", event -> {if(saveValue==""){t.setValue("");saveValue = fieldValue;fieldValue ="";operation="+";}}));
        d5.add(new Button("-", event -> {if(saveValue==""){t.setValue("");saveValue = fieldValue;fieldValue ="";operation="-";}}));
        operators.add(d5);
        Div d6 = new Div();
        d6.add(new Button("*", event -> {if(saveValue==""){t.setValue("");saveValue = fieldValue;fieldValue ="";operation="*";}}));
        d6.add(new Button("/", event -> {if(saveValue==""){t.setValue("");saveValue = fieldValue;fieldValue ="";operation="/";}}));
        operators.add(d6);
        Div d7 = new Div();
        d7.add(new Button("c", event -> {t.setValue("");saveValue = "";fieldValue ="";operation="";}));
        d7.add(new Button("=", event -> {fieldValue = ""+calculate();saveValue = "";operation="";t.setValue(""+fieldValue);}));
        operators.add(d7);
        container.add(chiffres);
        container.add(operators);
        container.getStyle().set("text-align", "center");
        container.getStyle().set("display", "flex");
        container.getStyle().set("flex-direction", "row");
        l.add(container);
        t.setValue(""+fieldValue);
    }
    private int calculate() {
        switch(operation){
            case "+" : return Integer.valueOf(fieldValue) + Integer.valueOf(saveValue);
            case "-" : return Integer.valueOf(saveValue) - Integer.valueOf(fieldValue);
            case "/" :{ if(Integer.valueOf(fieldValue)!=0){return Integer.valueOf(saveValue) / Integer.valueOf(fieldValue);}else{return 0;}}
            case "*" : return Integer.valueOf(fieldValue) * Integer.valueOf(saveValue);
            default : return 0;
            
        }

    }

    
}