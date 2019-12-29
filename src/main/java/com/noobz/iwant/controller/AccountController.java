package com.noobz.iwant.controller;

import com.noobz.iwant.core.result.Result;
import com.noobz.iwant.entity.Account;
import com.noobz.iwant.service.AccountService;
import com.noobz.iwant.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author zhousz
 * @date 2019/12/29 0:42
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class AccountController {

  @Autowired
  private AccountService accountService;

  @PostMapping("/avatar")
  public Result uploadAvatar(@RequestBody HashMap<String, String> mo) {
    Account currentUser = SecurityUtil.getCurrentUser();
    String avatar = mo.get("avatar");
    currentUser.setAvatar(avatar.getBytes());
    return Result.success(accountService.updateAccount(currentUser));
  }


}
