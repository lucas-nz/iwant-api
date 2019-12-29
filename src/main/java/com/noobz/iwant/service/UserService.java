package com.noobz.iwant.service;

import com.noobz.iwant.core.exception.BizException;
import com.noobz.iwant.entity.Account;
import com.noobz.iwant.entity.User;
import com.noobz.iwant.mapper.UserMapper;
import com.noobz.iwant.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhousz
 * @date 2019/12/29 14:17
 */
@Service
public class UserService {

  @Autowired
  UserMapper userMapper;


  @Transactional(rollbackFor = Exception.class)
  public int save(User user) {
    String idno = user.getIdno();
    Account account = SecurityUtil.getCurrentUser();
    Integer accountId = account.getId();
    user.setAccountId(accountId);
    userMapper.deleteByAccountId(accountId);
    if (null != userMapper.selectByIdno(idno)) {
      throw new BizException("身份证号被占用");
    }
    if (null != userMapper.selectByMobile(user.getMobile())) {
      throw new BizException("手机号被占用");
    }
    return userMapper.insertSelective(user);
  }

  public User getUserByAccountId (Integer accountId) {
    return userMapper.getUserByAccountId(accountId);
  }
}
