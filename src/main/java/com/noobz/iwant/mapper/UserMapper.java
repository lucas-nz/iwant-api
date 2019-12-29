package com.noobz.iwant.mapper;

import com.noobz.iwant.entity.User;

public interface UserMapper {

  int insert(User record);

  int insertSelective(User record);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);

  int deleteByAccountId(Integer accountId);

  User selectByIdno(String idno);

  User selectByMobile(String mobile);

  User getUserByAccountId(Integer accountId);
}