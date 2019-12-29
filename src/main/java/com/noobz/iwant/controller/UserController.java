package com.noobz.iwant.controller;

import com.noobz.iwant.core.result.Result;
import com.noobz.iwant.entity.Account;
import com.noobz.iwant.entity.User;
import com.noobz.iwant.service.AccountService;
import com.noobz.iwant.service.UserService;
import com.noobz.iwant.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhousz
 * @date 2019/12/29 14:16
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @Autowired
  AccountService accountService;

  @PostMapping("/save")
  public Result save(@RequestBody User user) {
    return Result.success(userService.save(user));
  }

  @GetMapping("/info")
  public Result getUserInfo() {
    Account currentUser = SecurityUtil.getCurrentUser();
    Integer id = currentUser.getId();
    return Result.success(userService.getUserByAccountId(id));
  }


}
