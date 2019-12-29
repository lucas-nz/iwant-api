package com.noobz.iwant.utils;

import com.noobz.iwant.entity.Account;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author zhousz
 * @date 2019/12/29 0:38
 */
public class SecurityUtil {

  public static Authentication getCurrentUserAuthentication() {
    return SecurityContextHolder.getContext().getAuthentication();
  }


  public static Account getCurrentUser() {
    return (Account) getCurrentUserAuthentication().getPrincipal();
  }
}
