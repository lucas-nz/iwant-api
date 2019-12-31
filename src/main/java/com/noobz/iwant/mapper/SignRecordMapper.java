package com.noobz.iwant.mapper;

import com.noobz.iwant.entity.SignRecord;
import com.noobz.iwant.entity.SignRecordExample;
import com.noobz.iwant.entity.SignRecordKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignRecordMapper {
    int countByExample(SignRecordExample example);

    int deleteByExample(SignRecordExample example);

    int deleteByPrimaryKey(SignRecordKey key);

    int insert(SignRecord record);

    int insertSelective(SignRecord record);

    List<SignRecord> selectByExample(SignRecordExample example);

    SignRecord selectByPrimaryKey(SignRecordKey key);

    int updateByExampleSelective(@Param("record") SignRecord record, @Param("example") SignRecordExample example);

    int updateByExample(@Param("record") SignRecord record, @Param("example") SignRecordExample example);

    int updateByPrimaryKeySelective(SignRecord record);

    int updateByPrimaryKey(SignRecord record);
}