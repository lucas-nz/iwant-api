package com.noobz.iwant.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.noobz.iwant.core.result.Result;
import com.noobz.iwant.entity.User;
import com.noobz.iwant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zhousz
 * @date 2019/12/26 22:30
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserService userService;

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // 定义用户和权限
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService);
  }

  // 自定义资源认证保护
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
      .antMatchers("/","/api/register","/login","/401","/css/**","/js/**")
      .permitAll()
      .anyRequest()
      .authenticated()
      .and()
      .formLogin()
      .loginProcessingUrl("/api/login")
      .loginPage("/login")
      .usernameParameter("username")
      .passwordParameter("password")
      .successHandler(new AuthenticationSuccessHandler() {
        @Override
        public void onAuthenticationSuccess(HttpServletRequest req,
                                            HttpServletResponse resp,
                                            Authentication authentication) throws IOException, ServletException {
          resp.setContentType("application/json;charset=utf-8");
          PrintWriter writer = resp.getWriter();
          User user = (User) authentication.getPrincipal();
          user.setPassword(null);
          Result result = Result.success(user);
          String s = new ObjectMapper().writeValueAsString(result);
          writer.write(s);
          writer.flush();
          writer.close();
        }
      })
      .failureHandler(new AuthenticationFailureHandler() {
        @Override
        public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException, ServletException {
          resp.setContentType("application/json;charset=utf-8");
          PrintWriter out = resp.getWriter();
          Result error = Result.error("登录失败");
          if (exception instanceof LockedException) {
            error.setErrorMsg("账户被锁定，请联系管理员!");
          } else if (exception instanceof CredentialsExpiredException) {
            error.setErrorMsg("密码过期，请联系管理员!");
          } else if (exception instanceof AccountExpiredException) {
            error.setErrorMsg("账户过期，请联系管理员!");
          } else if (exception instanceof DisabledException) {
            error.setErrorMsg("账户被禁用，请联系管理员!");
          } else if (exception instanceof BadCredentialsException) {
            error.setErrorMsg("用户名或者密码输入错误，请重新输入!");
          }
          out.write(new ObjectMapper().writeValueAsString(error));
          out.flush();
          out.close();
        }
      })
      .permitAll()
      .and()
      .logout()
      .logoutSuccessHandler(new LogoutSuccessHandler() {
        @Override
        public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
          resp.setContentType("application/json;charset=utf-8");
          PrintWriter out = resp.getWriter();
          out.write(new ObjectMapper().writeValueAsString(Result.success("注销成功!")));
          out.flush();
          out.close();
        }
      })
      .permitAll()
      .and()
      .csrf().disable().exceptionHandling()
      //没有认证时，在这里处理结果，不要重定向
      .authenticationEntryPoint(new AuthenticationEntryPoint() {
        @Override
        public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException authException) throws IOException, ServletException {
          resp.setContentType("application/json;charset=utf-8");
          PrintWriter out = resp.getWriter();
          Result error = Result.error("访问失败!");
          if (authException instanceof InsufficientAuthenticationException) {
            error.setErrorMsg("身份验证失败!");
          }
          out.write(new ObjectMapper().writeValueAsString(error));
          out.flush();
          out.close();
        }
      })

    ;
  }

}
