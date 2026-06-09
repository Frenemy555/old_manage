package com.tianya.demos.pojo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SysUser {
    @NotNull
    private Long id;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String realName;
    private String phone;
    private Integer role; //1管理员2护理3家属4医护
    private Integer status;//0禁用1正常
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;//0未删1删除
}
