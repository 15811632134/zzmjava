package com.zzm.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResultDTO<T> {
    /**
     * 结果码
     */
    @ApiModelProperty(value = "结果码")
    private Integer code;

    /**
     * 提示信息
     */
    @ApiModelProperty(value = "提示信息")
    private String message;

    /**
     * 具体内容
     */
    @ApiModelProperty(value = "返回内容")
    private T data;

}
