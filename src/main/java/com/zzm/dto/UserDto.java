package com.zzm.dto;

import io.swagger.annotations.ApiParam;
import lombok.*;

import java.io.Serializable;

/**
 * <pre>
 * 实体类
 * 数据库表名称：pdt_company
 * </pre>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto implements Serializable {

    private static final long serialVersionUID = -2738144888976911394L;

    @ApiParam(value = "名称")
    private String name;

    @ApiParam(value = "状态")
    private Integer status;

    @ApiParam(value = "图片Id")
    private Integer image_id;
}