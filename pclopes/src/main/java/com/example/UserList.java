package com.example;

import com.example.application.views.MainLayout;
import com.example.rest.User;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
@AnonymousAllowed  
@PageTitle("users") 
@Route(value = "users",layout = MainLayout.class)
public class UserList extends VerticalLayout {

    public UserList(UsersService service){

        var grid = new Grid<User>(User.class);
        grid.setItems(service.getUsers());

        add(grid);
    }

}