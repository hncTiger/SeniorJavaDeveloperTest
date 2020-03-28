package com.hzh.codetest.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hzh.codetest.respone.converter.ErrorCode;
import com.hzh.codetest.respone.converter.ResultWrapper;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResultWrapper> exceptionHandler(Exception e) {
        //log.error("exception.", e);
        return ResponseEntity.ok(new ResultWrapper(ErrorCode.SERVER_ERROR));
    }
}
