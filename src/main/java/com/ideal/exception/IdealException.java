package com.ideal.exception;


import com.ideal.common.resp.BaseResponse;
import com.ideal.consts.Const;
import com.ideal.enums.MessageCodeEnum;


/**
 * 自定义异常
 * Created by xingxiao on 2017/11/13 0013.
 */
public class IdealException extends RuntimeException {


    protected Integer result = Const.ERROR_SERVER;
    protected String msg = MessageCodeEnum.SYSTEM_ERROR.getMsg();
    protected MessageCodeEnum msgCodeEnum;
    protected BaseResponse baseResponse;
    private String msgCode = MessageCodeEnum.SYSTEM_ERROR.getMsgCode();

    public IdealException() {
    }

    public IdealException(String msg) {
        this.msg = msg;
    }

    public IdealException(MessageCodeEnum msgCodeEnum) {
        this.msgCodeEnum = msgCodeEnum;
    }

    public IdealException(BaseResponse baseResponse) {
        this.baseResponse = baseResponse;
    }

    public IdealException(String msg, BaseResponse baseResponse) {
        this.msg = msg;
        this.baseResponse = baseResponse;
    }

    public IdealException(String msg, Integer result) {
        this.msg = msg;
        this.result = result;
    }

    public IdealException(MessageCodeEnum msgCodeEnum, Integer result) {
        this.msgCodeEnum = msgCodeEnum;
        this.result = result;
    }

    public IdealException(String msg, String msgCode) {
        this.msg = msg;
        this.msgCode = msgCode;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public MessageCodeEnum getMsgCodeEnum() {
        return msgCodeEnum;
    }

    public void setMsgCodeEnum(MessageCodeEnum msgCodeEnum) {
        this.msgCodeEnum = msgCodeEnum;
    }

    public BaseResponse getBaseResponse() {
        return baseResponse;
    }

    public void setBaseResponse(BaseResponse baseResponse) {
        this.baseResponse = baseResponse;
    }
}
