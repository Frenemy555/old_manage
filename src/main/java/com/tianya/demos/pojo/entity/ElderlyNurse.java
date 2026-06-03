package com.tianya.demos.pojo.entity;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ElderlyNurse {
    private Long id;
    private Long elderlyId;
    private Long nurseItemId;//护理项目id
    private Long nurseUserId;//护理人员sys_user.id
    private LocalDateTime nurseTime;
    private String remark;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}