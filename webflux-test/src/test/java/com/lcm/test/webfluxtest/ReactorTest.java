package com.lcm.test.webfluxtest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-03 11:52
 **/
@SpringBootTest
public class ReactorTest {

    private Flux<Integer> generateFluxFrom1To6() {
        return Flux.just(1, 2, 3, 4, 5, 6);
    }
    private Mono<Integer> generateMonoWithError() {
        return Mono.error(new Exception("some error"));
    }

    @Test
    void contextLoads() {
        StepVerifier.create(generateFluxFrom1To6())
                //测试下一个期望的数据元素
                .expectNext(1, 2, 3, 4, 5, 6)
                //expectComplete用于测试下一个元素是否为完成信号
                .expectComplete()
                .verify();
        StepVerifier.create(generateMonoWithError())
                //校验下一个元素是否为错误信号
                .expectErrorMessage("some error")
                .verify();
    }

}
