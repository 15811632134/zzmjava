package com.zzm.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel
@Data
@NoArgsConstructor
@Table(name = "images")
public class Images implements Serializable {
    private static final long serialVersionUID = -4863145697272852981L;
    @Id
    @Column(name = "id")
    @KeySql(useGeneratedKeys = true)
    @ApiModelProperty(value = "主键ID", example = "")
    private Integer id;

    @ApiModelProperty(value = "")
    @Column(name = "filePath")
    private String filePath;

}

