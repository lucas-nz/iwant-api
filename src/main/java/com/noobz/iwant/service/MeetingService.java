package com.noobz.iwant.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.noobz.iwant.entity.Meeting;
import com.noobz.iwant.entity.MeetingExample;
import com.noobz.iwant.mapper.MeetingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhousz
 * @date 2019/12/30 14:33
 */
@Service
public class MeetingService {

  @Autowired
  MeetingMapper meetingMapper;

  /**
   * 查询所有会议
   * @param page
   * @param limit
   * @return com.github.pagehelper.PageInfo<com.noobz.iwant.entity.Meeting>
   * @throws
   * @author zhousz
   * @date 2019/12/30  14:44
   */
  public PageInfo<Meeting> listMeetings(Integer page, Integer limit) {
    PageHelper.startPage(page, limit);
    MeetingExample example = new MeetingExample();
    example.setOrderByClause("create_time desc");
    List<Meeting> meetings = meetingMapper.selectByExample(example);
    return new PageInfo<>(meetings);
  }


  public Meeting getMeetingInfo(Integer meetingId) {
    return meetingMapper.selectByPrimaryKey(meetingId);
  }
}
