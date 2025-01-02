package com.base.template.dto;

import com.base.template.domain.ResponseCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseResponseDto {
    private ResponseCode success;
    private String message;
    private Object data;

    public static BaseResponseDto of(ResponseCode code, String message) {
        return new BaseResponseDto(code, message, null);
    }

    public static BaseResponseDto of(ResponseCode code, String message, Object data) {
        return new BaseResponseDto(code, message, data);
    }

    public ResponseCode isSuccess() {
        return success;
    }

}