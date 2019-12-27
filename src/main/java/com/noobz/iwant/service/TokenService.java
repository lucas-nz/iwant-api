package com.noobz.iwant.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.noobz.iwant.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author zhousz
 * @date 2019/12/26 11:14
 */
@Service
public class TokenService {


  public String getToken(User user)  {
    String token = "";
    token = JWT.create().withAudience(user.getId())
      .sign(Algorithm.HMAC256(user.getPassword()));
    return token;
  }
}
