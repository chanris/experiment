package com.chenyue.experiment.basic.jdk8.optional;


import java.util.ArrayList;
import java.util.List;


/**
 * @author chenyue7@foxmail.com
 * @date 5/1/2024
 * @description
 */
public class UserDao {
    public UserInfo getUserInfoById(Long id) {
        if(id.equals(1L)) {
            return new UserInfo(1L, "chenyue", "12322");
        }
        return null;
    }

    public List<UserInfo> getAll() {
        return new ArrayList<>();
    }
}
