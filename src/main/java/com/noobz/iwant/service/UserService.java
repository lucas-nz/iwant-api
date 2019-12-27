package com.noobz.iwant.service;

import com.noobz.iwant.entity.User;
import com.noobz.iwant.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author zhousz
 * @date 2019/12/26 11:20
 */
@Service
public class UserService implements UserDetailsService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userMapper.getUserByUsername(username);
    if (null == user) {
      throw new UsernameNotFoundException("用户不存在");
    }
    return user;
  }

  public User getUserByUsername(String username) {
    return userMapper.getUserByUsername(username);
  }

  public User getUserById(String id) {
    return userMapper.getUserByUsername(id);
  }

  public int saveUser(User user) {
    return userMapper.saveUser(user.getUsername(), user.getPassword());
  }

}
