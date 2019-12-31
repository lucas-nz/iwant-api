package com.noobz.iwant.utils;

import com.noobz.iwant.core.exception.BizException;
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
    Account account = null;
    try {
      account = (Account) getCurrentUserAuthentication().getPrincipal();
    } catch (Exception e) {
      throw new BizException("登录过期");
    }
    return account;
  }

  /**
   * 获取系统用户名称
   * @return 系统用户名称
   */
  public static String getUsername(){
    return getCurrentUser().getUsername();
  }

  /**
   * 获取系统用户id
   * @return 系统用户id
   */
  public static Integer getUserId(){
    return getCurrentUser().getId();
  }
}
