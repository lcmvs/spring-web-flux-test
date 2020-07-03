package com.lcm.test.webfluxtest.controller;

import com.lcm.test.webfluxtest.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-03 09:52
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, WebFlux !";
    }

    @PostMapping("/user")
    public Mono<User> getUser() {
        User user = new User();
        user.setName("lcm");
        user.setDesc("呵呵");
        return Mono.just(user);
    }

}
