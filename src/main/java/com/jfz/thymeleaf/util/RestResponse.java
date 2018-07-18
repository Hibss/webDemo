package com.jfz.thymeleaf.util;

import lombok.Data;

/**
 * @author issac.yu
 * @date 2017/5/16
 * @description
 */

@Data
public class RestResponse {
    private Integer status;
    private Integer errorCode;
    private String errorMessage;
    private Object data;

    public static RestResponse createSuccess() {
        RestResponse restResponse = new RestResponse();
        restResponse.setStatus(Status.SUCCESS.getCode());
        restResponse.setData("SUCCESS");

        return restResponse;
    }

    public static RestResponse createSuccess(Object data) {
        RestResponse restResponse = new RestResponse();
        restResponse.setStatus(Status.SUCCESS.getCode());
        restResponse.setData(data);

        return restResponse;
    }

    public static RestResponse createFailed(Integer errorCode, String errorMessage) {
        return createFailed(errorCode, errorMessage, null);
    }

    public static RestResponse createFailed(Integer errorCode, String errorMessage, Object data) {
        RestResponse restResponse = new RestResponse();
        restResponse.setStatus(Status.FAILED.getCode());
        restResponse.setErrorCode(errorCode);
        restResponse.setErrorMessage(errorMessage);
        restResponse.setData(data);

        return restResponse;
    }
}
