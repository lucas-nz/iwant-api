package com.noobz.iwant.controller;

import com.github.pagehelper.PageInfo;
import com.noobz.iwant.core.result.Result;
import com.noobz.iwant.entity.Meeting;
import com.noobz.iwant.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhousz
 * @date 2019/12/30 14:12
 */
@RestController
@CrossOrigin
@RequestMapping("/meeting")
public class MeetingController {

  @Autowired
  MeetingService meetingService;

  @GetMapping("/{meetingId}")
  public Result getMeetingInfo(@PathVariable Integer meetingId) {
    return Result.success(meetingService.getMeetingInfo(meetingId));
  }



  //获取最新会议
  @GetMapping("/latest")
  public Result getLatest() {

    PageInfo<Meeting> pageInfo = meetingService.listMeetings(1, 10);
    List<Meeting> meetings = pageInfo.getList();
    if (meetings.size() > 0) {
      return Result.success(meetings.get(0));
    }
    return Result.success();
  }

  //获取所有会议
  @GetMapping("/all")
  public Result getAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
                       @RequestParam(name = "limit", defaultValue = "10") Integer limit) {
    PageInfo<Meeting> pageInfo = meetingService.listMeetings(page, limit);
    List<Meeting> meetings = pageInfo.getList();
    return Result.success(meetings);
  }

}
