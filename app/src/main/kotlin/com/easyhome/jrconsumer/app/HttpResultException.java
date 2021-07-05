package com.easyhome.jrconsumer.app;
import com.easyhome.jrconsumer.mvp.extension.ErrorInfo;

import java.io.IOException;


public class HttpResultException extends IOException {
    private ErrorInfo errorInfo;

    public HttpResultException(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public HttpResultException(String detailMessage) {
        super(detailMessage);
    }


    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }
}
