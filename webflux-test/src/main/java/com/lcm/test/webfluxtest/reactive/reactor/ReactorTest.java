package com.lcm.test.webfluxtest.reactive.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-03 11:19
 **/

public class ReactorTest {

    public static void main(String[] args){
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6);
        Mono<Integer> mono = Mono.just(1);

        flux.subscribe(System.out::print);

        flux.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {

            }
        });
        flux.map(i -> i * i)
                .subscribe(System.out::print);


    }

    private static void declareTest(){
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6);
        Mono<Integer> mono = Mono.just(1);

        //基于数组
        Integer[] array = new Integer[]{1,2,3,4,5,6};
        Flux<Integer> flux1 = Flux.fromArray(array);
        //基于集合
        List<Integer> list = Arrays.asList(array);
        Flux<Integer> flux2 = Flux.fromIterable(list);
        //基于流
        Stream<Integer> stream = list.stream();
        Flux<Integer> flux3 = Flux.fromStream(stream);
    }


    private static void completeTest(){
        // 只有完成信号的空数据流
        Flux<Object> emptyFlux = Flux.just();
        Flux.empty();
        Mono.empty();
        Mono.justOrEmpty(Optional.empty());
    }


    private static void errorTest(){
        // 只有错误信号的数据流
        Flux<Object> errorFlux = Flux.error(new Exception("some error"));
        Mono.error(new Exception("some error"));
    }

}
