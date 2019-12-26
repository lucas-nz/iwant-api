package com.noobz.iwant.core.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.noobz.iwant.core.annotations.PassToken;
import com.noobz.iwant.core.annotations.UserLoginToken;
import com.noobz.iwant.core.exception.NotPassAuthenticationException;
import com.noobz.iwant.entity.User;
import com.noobz.iwant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 验证拦截器
 *
 * @author zhousz
 * @date 2019/12/26 11:17
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

  @Autowired
  private UserService userService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String token = request.getHeader("token");
    // 如果不是映射到方法上直接通过
    if (!(handler instanceof HandlerMethod)) {
      return true;
    }

    HandlerMethod handlerMethod = (HandlerMethod) handler;
    Method method = handlerMethod.getMethod();
    // 检查是否有passtoken注解, 有则跳过认证
    if (method.isAnnotationPresent(PassToken.class)) {
      PassToken passToken = method.getAnnotation(PassToken.class);
      if (passToken.required()) {
        return true;
      }
    }

    // 检查是否有登录权限的注解.
    if (method.isAnnotationPresent(UserLoginToken.class)) {
      UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
      if (userLoginToken.required()) {
        // 执行认证
        if (null == token) {
          throw new NotPassAuthenticationException("请重新登录");
        }
        //
        String userid;
        try {
          userid = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException e) {
          throw new NotPassAuthenticationException("请重新登录");
        }
        User user = userService.getUserById(userid);
        if (null == user) {
          throw new NotPassAuthenticationException("用户不存在, 请重新登录");
        }

        // 验证token
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
          verifier.verify(token);
        } catch (JWTVerificationException e) {
          throw new NotPassAuthenticationException("验证失败, 请重新登录");
        }

        return true;
      }
    }


    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
  }
}
