package com.noobz.iwant.api;

import com.noobz.iwant.core.annotations.UserLoginToken;
import com.noobz.iwant.core.result.Result;
import com.noobz.iwant.core.result.ResultCode;
import com.noobz.iwant.entity.User;
import com.noobz.iwant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhousz
 * @date 2019/12/26 13:27
 */
@CrossOrigin
@RestController
@RequestMapping("api")
public class LoginApi {

  @Autowired
  UserService userService;

  @PostMapping("/register")
  public Result register(@RequestBody User user) {
    User user4db = userService.getUserByUsername(user.getUsername());
    if (null != user4db) {
      return Result.error(ResultCode.USER_HAS_EXISTED);
    }
    String password = user.getPassword();
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String passwordAfterEncode = passwordEncoder.encode(password);
    user.setPassword(passwordAfterEncode);
    int i = userService.saveUser(user);
    return Result.success(i);
  }


  @GetMapping("/msg")
  @UserLoginToken
  public Result getMsg() {
    return Result.success("kkk");
  }


}
