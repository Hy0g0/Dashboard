package com.example;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;
import com.example.rest.User;

@Service 
public class UsersService {

    private final WebClient webClient;

    public UsersService(WebClient.Builder builder){
        webClient = builder.baseUrl("https://jsonplaceholder.typicode.com/").build();
    }

    public User[] getUsers(){
        return webClient
            .get()
            .uri("/users")
            .retrieve()
            .bodyToMono(User[].class).block();
    }
}