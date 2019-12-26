package com.noobz.iwant.api;

import com.alibaba.fastjson.JSONObject;
import com.noobz.iwant.core.annotations.UserLoginToken;
import com.noobz.iwant.core.exception.BizException;
import com.noobz.iwant.core.result.Result;
import com.noobz.iwant.entity.User;
import com.noobz.iwant.service.TokenService;
import com.noobz.iwant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhousz
 * @date 2019/12/26 13:27
 */
@CrossOrigin
@RestController
@RequestMapping("api")
public class UserApi {

  @Autowired
  UserService userService;

  @Autowired
  TokenService tokenService;

  @PostMapping("/login")
  public Result login(@RequestBody User user) {
    JSONObject jo = new JSONObject();
    String username = user.getUsername();
    String password = user.getPassword();
    User user4db = userService.getUserByUsername(username);
    if (null == user4db) {
      throw new BizException("用户不存在");
    }
    if (!password.equals(user4db.getPassword())) {
      throw new BizException("密码错误");
    } else {
      jo.put("user", user4db);
      String token = tokenService.getToken(user);
      jo.put("token", token);
      return Result.success(jo);
    }

  }


  @GetMapping("/msg")
  @UserLoginToken
  public Result getMsg() {
    return Result.success("kkk");
  }


}
