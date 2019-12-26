package com.noobz.iwant.core.result;

public enum ResultCode {

  /* 成功状态码 */
  SUCCESS(true, 0, "成功"),
  ERROR(false, -1, "失败"),

  /* 参数错误：10001-19999 */
  PARAM_IS_INVALID( false, 10001, "参数无效"),
  PARAM_IS_BLANK( false, 10002, "参数为空"),
  cslx_BIND_ERROR( false, 10003, "参数类型错误"),
  PARAM_NOT_COMPLETE( false, 10004, "参数缺失"),


  /* 用户错误：20001-29999*/
  USER_NOT_LOGGED_IN( false, 20001, "用户未登录"),
  USER_LOGIN_ERROR( false, 20002, "账号或密码错误"),
  USER_ACCOUNT_FORBIDDEN( false, 20003, "账号已被禁用"),
  USER_NOT_EXIST( false, 20004, "用户不存在"),
  USER_HAS_EXISTED( false, 20005, "用户已存在"),
  USER_Register_ERROR( false, 20006, "用户注册错误"),

  /* 业务错误：30001-39999 */
  SPECIFIED_QUESTIONED_USER_NOT_EXIST( false, 30001, "某业务出现问题"),

  /* 系统错误：40001-49999 */
  SYSTEM_INNER_ERROR( false, 40001, "系统繁忙，请稍后重试"),

  /* 数据错误：50001-599999 */
  RESULE_DATA_NONE( false, 50001, "数据未找到"),
  DATA_IS_WRONG( false, 50002, "数据有误"),
  DATA_ALREADY_EXISTED( false, 50003, "数据已存在"),
  RECORD_NOT_EXIST(false, 50004, "记录不存在"),

  /* 接口错误：60001-69999 */
  INTERFACE_INNER_INVOKE_ERROR( false, 60001, "内部系统接口调用异常"),
  INTERFACE_OUTTER_INVOKE_ERROR( false, 60002, "外部系统接口调用异常"),
  INTERFACE_FORBID_VISIT( false, 60003, "该接口禁止访问"),
  INTERFACE_ADDRESS_INVALID( false, 60004, "接口地址无效"),
  INTERFACE_REQUEST_TIMEOUT( false, 60005, "接口请求超时"),
  INTERFACE_EXCEED_LOAD( false, 60006, "接口负载过高"),
  INTERFACE_METHOD_NOTSUPPORTED( false, 60007, "接口方法不支持"),
  /* 权限错误：70001-79999 */
  PERMISSION_NO_ACCESS( false, 70001, "无访问权限"),

  /* 文件上传 */
  UPLOAD_ERROR(false, 80001, "上传失败"),

  /* 文件读写 */
  FILE_READORWRITE_ERROR(false, 90001, "文件读写错误.");




  private Boolean success;
  private Integer code;
  private String msg;

  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  ResultCode(Boolean success, Integer code, String msg) {
    this.success = success;
    this.code = code;
    this.msg = msg;
  }
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public static String getMsg(String name) {
    for (ResultCode item:
         ResultCode.values()) {
      if (item.name().equals(name)) {
        return item.msg;
      }
    }
    return name;
  }

  public static Integer getCode(String name) {
    for (ResultCode item:
         ResultCode.values()) {
      if (item.name().equals(name)) {
        return item.code;
      }
    }
    return null;
  }
}



