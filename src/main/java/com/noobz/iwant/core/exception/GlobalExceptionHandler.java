package com.noobz.iwant.core.exception;

import com.noobz.iwant.core.result.Result;
import com.noobz.iwant.core.result.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhousz
 * @date 2019/12/26 13:31
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  @ResponseBody
  @ExceptionHandler(BizException.class)
  public Result bizExceptionHandler(BizException e) {
    e.printStackTrace();
    return Result.error(e.getMessage());
  }

  @ResponseBody
  @ExceptionHandler(Exception.class)
  public Result systemErrorHandler(Exception e) {
    e.printStackTrace();
    return Result.error(ResultCode.SYSTEM_INNER_ERROR);
  }

}
