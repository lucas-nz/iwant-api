package com.noobz.iwant.mapper;

import com.noobz.iwant.entity.Account;
import com.noobz.iwant.entity.User;

public interface AccountMapper {

  Account getAccountByUsername(String username);

  Account getUserById(Integer id);

  int deleteByPrimaryKey(Integer id);

  int insert(Account record);

  int insertSelective(Account record);

  Account selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Account record);

  int updateByPrimaryKeyWithBLOBs(Account record);

  int updateByPrimaryKey(Account record);

  User getUserByAccountId(Integer accountId);

}