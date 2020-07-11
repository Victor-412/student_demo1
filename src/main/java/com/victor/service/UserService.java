package com.victor.service;

import com.victor.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    User login(@Param("userName") String userName, @Param("password") String password);

}
