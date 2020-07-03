package com.lcm.test.webfluxtest.controller.function.config;

import com.lcm.test.webfluxtest.controller.function.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-03 16:42
 **/

@Configuration
public class RouterConfig {

    @Autowired
    private TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return route(GET("/webflux/function/time"), req -> timeHandler.getTime(req))
                .andRoute(GET("/webflux/function/date"), timeHandler::getDate)
                .andRoute(GET("/webflux/function/times"), timeHandler::sendTimePerSec);
    }

}

