package com.zzm.vo;

import io.swagger.annotations.ApiParam;
import lombok.*;

import java.io.Serializable;

/**
 * <pre>
 * 实体类
 * 数据库表名称：pdt_company
 * </pre>
 */
@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = -2738144888976911394L;

    @ApiParam(value = "id")
    private Integer id;

    @ApiParam(value = "名称")
    private String name;

    @ApiParam(value = "状态")
    private Integer status;

    @ApiParam(value = "图片路径")
    private String filePath;
}