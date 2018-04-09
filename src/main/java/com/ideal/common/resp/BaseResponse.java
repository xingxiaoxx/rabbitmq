package com.ideal.common.resp;

import com.ideal.enums.MessageCodeEnum;

import java.io.Serializable;

/**
 * 响应结果集
 * Created by xingxiao on 2017/11/13 0013.
 */
public class BaseResponse implements Serializable {

    private Integer result = 0;// 响应状态码，其值在Const类中
    private String message = MessageCodeEnum.SUCCESS.getMsg();
    private String messageCode = MessageCodeEnum.SUCCESS.getMsgCode();//错误码
    private Integer messageType = 0;//错误类型(0:默认,1:系统错误,2:业务错误)


    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    /**

     * 设置 描述响应状态的编码信息
     * @param result
     * @param message
     * @param messageType
     */
    public void setResCode(int result, String message, String messageCode, int messageType){
        this.result=result;
        this.message=message;
        this.messageCode=messageCode;
        this.messageType=messageType;
    }
}
