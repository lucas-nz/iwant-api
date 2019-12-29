package com.noobz.iwant.service;

import com.noobz.iwant.core.exception.BizException;
import com.noobz.iwant.entity.Account;
import com.noobz.iwant.entity.User;
import com.noobz.iwant.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author zhousz
 * @date 2019/12/26 11:20
 */
@Service
public class AccountService implements UserDetailsService {

  @Autowired
  private AccountMapper accountMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Account user = accountMapper.getAccountByUsername(username);
    if (null == user) {
      throw new BizException("用户不存在");
    }
    return user;
  }

  public Account getAccountByUsername(String username) {
    return accountMapper.getAccountByUsername(username);
  }

  public int saveUser(Account user) {
    return accountMapper.insertSelective(user);
  }

  public int updateAccount(Account account) {
    return accountMapper.updateByPrimaryKeyWithBLOBs(account);
  }

  public User getUserByAccountId(Integer accountId) {
    return accountMapper.getUserByAccountId(accountId);
  }

}
