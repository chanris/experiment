package com.chenyue.experiment.basic.optional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author chenyue7@foxmail.com
 * @date 5/1/2024
 * @description java optional 介绍详见： http://47.109.110.189/article/detail/54
 */
public class Test {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        Optional<UserInfo> userInfoOpt = Optional.ofNullable(userDao.getUserInfoById(1L));
        userInfoOpt.stream().forEach(item -> {
            System.out.println(item.getUsername());
        });
        Stream<UserInfo> stream = userInfoOpt.stream();

//        userInfoOpt.ifPresent(userInfo -> {
//            System.out.println(userInfo);
//        });
//        Optional<String> optionalUsername = userInfoOpt.map(item -> {
//            return item.getUsername();
//        });
//        Optional<String> chenyue = optionalUsername.filter(username -> {
//            return username.startsWith("chenyue");
//        });
//        chenyue.ifPresent(item -> {
//            System.out.println(item);
//        });

//        userInfoOpt.ifPresentOrElse(userInfo -> {
//            System.out.println(userInfo);
//        }, ()->{
//            System.out.println("UserInfo not found");
//        });
    }
}
