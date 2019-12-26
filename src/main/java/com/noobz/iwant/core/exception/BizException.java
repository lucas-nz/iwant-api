package com.noobz.iwant.core.exception;

/**
 * @author zhousz
 * @date 2019/12/26 14:49
 */
public class BizException extends RuntimeException {

  public BizException() {
  }

  public BizException(String message) {
    super(message);
  }

  public BizException(String message, Throwable cause) {
    super(message, cause);
  }

  public BizException(Throwable cause) {
    super(cause);
  }

  protected BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}