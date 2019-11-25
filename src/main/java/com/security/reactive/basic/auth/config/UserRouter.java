package com.security.reactive.basic.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.security.reactive.basic.auth.api.UserHandler;

@Configuration
public class UserRouter {

  @Bean
  public RouterFunction<ServerResponse> route(UserHandler userHandler) {

    return RouterFunctions.route(
            RequestPredicates.GET("/users")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
            userHandler::getAllUsers)
        .andRoute(
            RequestPredicates.GET("/users/{userId}")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
            userHandler::getUser)
        .andRoute(
            RequestPredicates.POST("/users")
                .and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)),
            userHandler::createUser)
        .andRoute(
            RequestPredicates.DELETE("/users/{userId}")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
            userHandler::deleteUser);
  }
}
