package com.noobz.iwant.entity.security;

import com.noobz.iwant.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author zhousz
 * @date 2019/12/28 13:53
 */

@AllArgsConstructor
@Getter
public class AuthenticationInfo implements Serializable {

  private final String token;

  private final Account account;



}
