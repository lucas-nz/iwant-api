package com.noobz.iwant.interceptor;

import com.noobz.iwant.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 验证拦截器
 * @author zhousz
 * @date 2019/12/26 11:17
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

  @Autowired
  private TokenService tokenService;





}
