package com.ideal.enums;


/**
 * 消息
 * Created by xingxiao on 2017/11/13 0013.
 */
public enum MessageCodeEnum {

    SUCCESS("0", "Success", "正常使用"),
    SYSTEM_ERROR("1", "System is busy, please try again.", "系统异常"),
    VALID_PARAMS_ERROR("2", "System is busy, please try again.", "参数校验失败");


    private String msgCode;
    private String msg;
    private String cnMsg;

    MessageCodeEnum(String msgCode, String msg, String cnMsg) {
        this.msgCode = msgCode;
        this.msg = msg;
        this.cnMsg = cnMsg;
    }

    public static MessageCodeEnum valueOfCode(String msgCode) {
        for (MessageCodeEnum messageCodeEnum : MessageCodeEnum.values()) {
            if (messageCodeEnum.getMsgCode().equals(msgCode)) {
                return messageCodeEnum;
            }
        }
        return SUCCESS;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCnMsg() {
        return cnMsg;
    }

    public void setCnMsg(String cnMsg) {
        this.cnMsg = cnMsg;
    }
}
