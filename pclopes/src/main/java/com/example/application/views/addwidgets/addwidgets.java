package com.example.application.views.addwidgets;

import java.util.List;

import com.example.application.Application;
import com.example.application.data.factory.CreatorFactory;
import com.example.application.data.factory.WidgetFactory;
import com.example.application.data.widget.WidgetCreator;
import com.example.application.data.widget.WidgetList;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;


@CssImport("./styles/createWidget.css")
@PageTitle("Add Widgets :")
@Route(value = "AddWidget", layout = MainLayout.class)
@AnonymousAllowed
public class addwidgets extends VerticalLayout {

    public addwidgets() {
        System.out.println("add widget");
        setSpacing(false);
        WidgetFactory factory = new WidgetFactory();
        CreatorFactory f = new CreatorFactory();
        List<WidgetCreator> l = f.create();
        for(WidgetCreator w : l) {
            add(w.getL());
            w.getL().add(new Button("add",event -> WidgetList.add(factory.create(w.getType()))));
        }
        setSizeFull();
        getStyle().set("text-align", "center");
        getStyle().set("display", "flex");
        getStyle().set("flex-direction", "row");    
        getStyle().set("flex-wrap", "wrap");
    }

}
