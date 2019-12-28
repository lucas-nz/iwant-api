package com.noobz.iwant.mapper;

import com.noobz.iwant.entity.User;
import com.noobz.iwant.entity.UserKey;
import com.noobz.iwant.entity.UserWithBLOBs;

public interface UserMapper {
    int deleteByPrimaryKey(UserKey key);

    int insert(UserWithBLOBs record);

    int insertSelective(UserWithBLOBs record);

    UserWithBLOBs selectByPrimaryKey(UserKey key);

    int updateByPrimaryKeySelective(UserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserWithBLOBs record);

    int updateByPrimaryKey(User record);
}