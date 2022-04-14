package com.zzm.exception;

/**
 * @Description 所有业务异常的枚举
 */
public enum BizExceptionEnum {

    SUCCESS(100, "成功"),
    SERVER_EXCEPTION(500, "服务器错误"),
    ERROR(-1, "未知异常"),
    SN_EXIST(10001, "设备S/N码已经存在"),
    DATA_ERROR(10002, "导入数据异常"),
    EXIST_VERSION(1003,"版本号已存在"),
    ERROR_VERSION(1004,"版本号长度应为1-10个字符"),
    DESCRIPTION_VERSION(1005,"描述长度应为1-150个字符"),
    NULL_UPDATE_TIMING(1006,"更新时间为空"),
    ERROR_APK(1007,"请上传正确的apk文件"),
    ERROR_EXE(1008,"请上传正确的exe文件"),
    ERROR_EXCEL(1008,"请上传正确的EXCEL文件"),
    ;


    BizExceptionEnum(int code, String message) {
        this.friendlyCode = code;
        this.friendlyMsg = message;
    }

    BizExceptionEnum(int code, String message, String urlPath) {
        this.friendlyCode = code;
        this.friendlyMsg = message;
        this.urlPath = urlPath;
    }

    private int friendlyCode;

    private String friendlyMsg;

    private String urlPath;

    public int getCode() {
        return friendlyCode;
    }

    public void setCode(int code) {
        this.friendlyCode = code;
    }

    public String getMessage() {
        return friendlyMsg;
    }

    public void setMessage(String message) {
        this.friendlyMsg = message;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

}
