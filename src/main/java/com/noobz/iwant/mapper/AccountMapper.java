package com.noobz.iwant.mapper;

import com.noobz.iwant.entity.Account;

public interface AccountMapper {

    Account getUserByUsername(String username);

    Account getUserById(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKeyWithBLOBs(Account record);

    int updateByPrimaryKey(Account record);
}