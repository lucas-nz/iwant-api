package com.noobz.iwant.controller;

import com.noobz.iwant.core.result.Result;
import com.noobz.iwant.entity.Account;
import com.noobz.iwant.service.SignService;
import com.noobz.iwant.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhousz
 * @date 2019/12/30 19:35
 */
@RestController
@RequestMapping("/sign")
public class SignController {


  @Autowired
  SignService signService;

  /**
   * 报名
   *
   * @param meetingId
   * @return com.noobz.iwant.core.result.Result
   * @throws
   * @author zhousz
   * @date 2019/12/30  20:51
   */
  @PostMapping("/{meetingId}")
  public Result sign(@PathVariable Integer meetingId) {
    Account user = SecurityUtil.getCurrentUser();
    Integer accountId = user.getId();
    return Result.success(signService.sign(accountId, meetingId));
  }


}
