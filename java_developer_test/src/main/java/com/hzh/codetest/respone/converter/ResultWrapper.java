package com.hzh.codetest.respone.converter;

import java.io.Serializable;
import lombok.Data;

@Data
public class ResultWrapper implements Serializable {

    private static final long serialVersionUID = 8560746590669383171L;

    private Object data;

    private Long timestamp = System.currentTimeMillis();

    private String message = ErrorCode.SUCCESS.getMsg();

    private int code = ErrorCode.SUCCESS.getCode();

    public ResultWrapper() {
    }

    public ResultWrapper(Object data) {
        this.data = data;
    }

    public ResultWrapper(Object data, ErrorCode errorCode) {
        this.data = data;
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public ResultWrapper(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
