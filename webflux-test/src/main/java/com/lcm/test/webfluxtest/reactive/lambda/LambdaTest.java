package com.lcm.test.webfluxtest.reactive.lambda;

import com.lcm.test.webfluxtest.pojo.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-03 10:51
 **/

public class LambdaTest {

    public static void main(String[] args){

    }

    private static void comparatorTest(){
        List<User> list=new ArrayList<>();
        //匿名内部类
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId()-o2.getId();
            }
        });
        //函数式编程
        list.sort((User o1, User o2) -> {return o1.getId()-o2.getId();});
        //简化
        list.sort((o1, o2) -> o1.getId()-o2.getId());
        //函数式接口
        list.sort(Comparator.comparingInt(User::getId));
    }


}
