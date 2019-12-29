package com.noobz.iwant.controller;

import com.noobz.iwant.core.exception.BizException;
import com.noobz.iwant.core.result.Result;
import com.noobz.iwant.core.result.ResultCode;
import com.noobz.iwant.entity.Account;
import com.noobz.iwant.entity.security.AuthenticationInfo;
import com.noobz.iwant.service.AccountService;
import com.noobz.iwant.service.UserService;
import com.noobz.iwant.utils.JwtTokenUtil;
import com.noobz.iwant.utils.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhousz
 * @date 2019/12/27 0:21
 */
@Slf4j
@RestController
@RequestMapping("auth")
public class AuthController {

  @Value("${jwt.header}")
  private String tokenHeader;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private AccountService accountService;

  @PostMapping(value = "/login")
  public Result login(@Validated @RequestBody Account account) {
    Account user = (Account) accountService.loadUserByUsername(account.getUsername());

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String passwordAfterEncode = passwordEncoder.encode(user.getPassword());

    if (passwordAfterEncode.equals(account.getPassword())) {
      throw new BizException("密码错误");
    }
    final String token = jwtTokenUtil.generateToken(user);

    return Result.success(new AuthenticationInfo(token, user));
  }

  @PostMapping("/register")
  public Result register(@RequestBody Account user) {
    Account user4db = accountService.getAccountByUsername(user.getUsername());
    if (null != user4db) {
      return Result.error(ResultCode.USER_HAS_EXISTED);
    }
    String password = user.getPassword();
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String passwordAfterEncode = passwordEncoder.encode(password);
    user.setPassword(passwordAfterEncode);
    int i = accountService.saveUser(user);
    return Result.success(i);
  }


  @GetMapping("/info")
  public Result getUserInfo() {
    Account account = SecurityUtil.getCurrentUser();
    Integer id = account.getId();
    return Result.success(accountService.getUserByAccountId(id));
  }


}
