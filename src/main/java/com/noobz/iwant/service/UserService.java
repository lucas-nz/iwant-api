package com.noobz.iwant.service;

import com.noobz.iwant.mapper.UserMapper;
import com.noobz.iwant.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhousz
 * @date 2019/12/26 11:20
 */
@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  public User getUserByUsername(String username) {
    return userMapper.getUserByUsername(username);
  }

  public User getUserById(String id) {
    return userMapper.getUserByUsername(id);
  }

}
