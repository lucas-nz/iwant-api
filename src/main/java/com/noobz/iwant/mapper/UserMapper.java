package com.noobz.iwant.mapper;

import com.noobz.iwant.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zhousz
 * @date 2019/12/26 11:20
 */

public interface UserMapper {

  @Select("select id, username, password from user where username = #{username}")
  User getUserByUsername(@Param("username") String username);


  User getUserById(@Param("id") String id);


}
