package com.noobz.iwant.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.noobz.iwant.core.result.Result;
import com.noobz.iwant.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
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
  private AccountService userService;

  /**
   * 自定义基于JWT的安全过滤器
   */
  @Autowired
  private JwtAuthorizationTokenFilter authenticationTokenFilter;

  @Autowired
  private JwtAuthenticationEntryPoint unauthorizedHandler;

  @Value("${jwt.header}")
  private String tokenHeader;

  @Bean
  PasswordEncoder passwordEncoderBean() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  GrantedAuthorityDefaults grantedAuthorityDefaults() {
    // Remove the ROLE_ prefix
    return new GrantedAuthorityDefaults("");
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  // 定义用户和权限
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService).passwordEncoder(passwordEncoderBean());
  }

  // 自定义资源认证保护
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http

      // 禁用 CSRF
      .csrf().disable()

      // 授权异常
      .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()

      // 不创建会话
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

      // 过滤请求
      .authorizeRequests()
      .antMatchers(
        HttpMethod.GET,
        "/*.html",
        "/**/*.html",
        "/**/*.css",
        "/**/*.js"
      ).anonymous()

      .antMatchers(HttpMethod.POST, "/auth/login").anonymous()
      .antMatchers(HttpMethod.POST, "/auth/register").anonymous()
      .antMatchers("/auth/vCode").anonymous()

      // swagger start
      .antMatchers("/swagger-ui.html").anonymous()
      .antMatchers("/swagger-resources/**").anonymous()
      .antMatchers("/webjars/**").anonymous()
      .antMatchers("/*/api-docs").anonymous()
      // swagger end

      // 接口限流测试
      .antMatchers("/test/**").anonymous()
      .antMatchers(HttpMethod.OPTIONS, "/**").anonymous()

      .antMatchers("/druid/**").anonymous()
      // 所有请求都需要认证
      .anyRequest().authenticated()
      .and()
      .logout()
      .logoutUrl("/auth/logout")
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
      // 防止iframe 造成跨域
      .and().headers().frameOptions().disable();

    http
      .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

  }

}
