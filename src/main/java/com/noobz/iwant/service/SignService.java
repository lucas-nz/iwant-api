package com.noobz.iwant.service;

import com.noobz.iwant.core.exception.BizException;
import com.noobz.iwant.entity.SignRecord;
import com.noobz.iwant.mapper.SignRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author zhousz
 * @date 2019/12/30 21:06
 */
@Service
public class SignService {


  @Autowired
  SignRecordMapper signRecordMapper;

  public int sign(Integer accountId, Integer meetingId) {
    SignRecord record = new SignRecord(accountId, meetingId, new Date());
    if (null != signRecordMapper.selectByPrimaryKey(record)) {
      throw new BizException("已经报过名了");
    }
    return signRecordMapper.insertSelective(record);
  }
}
