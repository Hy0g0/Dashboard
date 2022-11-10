package com.example.application.views.home;


import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.example.application.Application;

import com.example.application.data.widget.Widget;
import com.example.application.data.widget.WidgetList;
import com.example.application.data.widget.mywidgets.HorlogeWidget;
import com.example.application.data.widget.mywidgets.MeteoWidget;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.VaadinSession;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import javax.annotation.security.PermitAll;


@CssImport("./styles/myhome.css")
@PageTitle("Home")
@Route(value = "Home", layout = MainLayout.class)


@PermitAll
@AnonymousAllowed
public class HomeView extends VerticalLayout {

    public HomeView() {        
        System.out.println("Home");
        setSpacing(false);
       for(Widget w : WidgetList.getLists()){
        add(w.getL());
       }
       UI ui = UI.getCurrent();
        ExecutorService executor = Executors.newFixedThreadPool(10);    
        executor.execute(new Runnable() {
                @Override
                public void run() {
                      
                    while (true) {
                        try {
                            Thread.sleep(1000);
                            
                        } catch (Exception e) {
                           System.out.println("test : " +e);
                             
                        }
                        ui.access(()-> WidgetList.refresh());
                    }
                    
                }
            });

        setSizeFull();
        // setJustifyContentMode(JustifyContentMode.CENTER);
        // setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
        getStyle().set("display", "flex");
        getStyle().set("flex-direction", "row");
        getStyle().set("flex-wrap", "wrap");
        System.out.println("end home");

    }
}
