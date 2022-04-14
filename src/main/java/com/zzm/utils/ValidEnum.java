package com.zzm.utils;

import lombok.Getter;

@Getter
public enum ValidEnum {
    UN_VALID(0,"无效的"),
    VALID(1,"有效的");


    private int code;
    private String message;

    ValidEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
