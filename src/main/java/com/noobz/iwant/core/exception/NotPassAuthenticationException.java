package com.noobz.iwant.core.exception;

/**
 * 未通过身份验证异常
 * @author zhousz
 * @date 2019/12/26 12:29
 */
public class NotPassAuthenticationException extends RuntimeException {

  public NotPassAuthenticationException(String msg){
    super(msg);
  }

  public NotPassAuthenticationException(){
    super();
  }


}
