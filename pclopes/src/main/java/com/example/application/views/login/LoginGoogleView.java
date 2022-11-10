package com.example.application.views.login;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

@Route("loginGoogle")
@AnonymousAllowed
public class LoginGoogleView extends VerticalLayout {
    private static final String OAUTH_URL = "/oauth2/authorization/google";

    public LoginGoogleView() {
        Anchor loginLink = new Anchor(OAUTH_URL, "Login with Google");
        // Set router-ignore attribute so that Vaadin router doesn't handle the login
        // request
        loginLink.getElement().setAttribute("router-ignore", true);
        add(loginLink);
        getStyle().set("padding", "200px");
        setAlignItems(FlexComponent.Alignment.CENTER);

        Anchor login = new Anchor("/login", "Login");
        add(login);
        getStyle().set("padding", "200px");
        setAlignItems(FlexComponent.Alignment.CENTER);
    }
}