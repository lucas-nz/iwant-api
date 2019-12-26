package com.noobz.iwant.core.result;

public class Result<T> {


  public static Result error(String msg) {
    Result<Object> result = new Result<>();
    ResultCode error = ResultCode.ERROR;
    error.setMsg(msg);
    result.setResultCode(error);
    return result;
  }

  public static  <T>Result success(T data) {
    Result<T> result = new Result<T>();
    result.setResultCode(ResultCode.SUCCESS);
    result.setData(data);
    return result;
  }

  public static Result error(ResultCode code) {
    Result result = new Result();
    result.setResultCode(code);
    return result;
  }

  public static Result success() {
    Result result = new Result();
    result.setSuccess(true);
    result.setResultCode(ResultCode.SUCCESS);
    return result;
  }

  public Result() {}

  public Result(Boolean success, Integer code, String msg, T data) {
    this.success = success;
    this.errorCode = code;
    this.errorMsg = msg;
    this.data = data;
  }


  private Boolean success;
  private Integer errorCode;
  private String errorMsg;
  private T data;     

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public Boolean getSuccess() { return this.success; }

  public Integer getErrorCode() {
    return errorCode;
  }


  public String getErrorMsg() {
    return errorMsg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void setResultCode(ResultCode code) {
    this.success = code.getSuccess();
    this.errorCode = code.getCode();
    this.errorMsg = code.getMsg();
  }

}
