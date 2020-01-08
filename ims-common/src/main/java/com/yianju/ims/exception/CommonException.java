package com.yianju.ims.exception;

import com.yianju.ims.entity.ResultCode;

/**
 * 公共异常
 */
public class CommonException extends Exception{

    private ResultCode resultCode;

    public ResultCode getResultCode() {
        return resultCode;
    }

    public CommonException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
