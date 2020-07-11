package com.victor.mapper;


import com.victor.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User login(@Param("userName") String userName, @Param("password") String password);

}
