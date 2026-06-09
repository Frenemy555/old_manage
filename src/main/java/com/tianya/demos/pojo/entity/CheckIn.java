package com.tianya.demos.pojo.entity;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CheckIn {
    private Long id;
    private Long elderlyId;//老人id
    private Long bedId;//床位id
    private LocalDateTime checkInTime;
    private Long applyUserId;//申请人sys_user.id
    private Integer status;//0待审1通过2驳回
    private String remark;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;

    // 关联字段
    private String elderlyName;
    private String bedName;
    private String roomName;
    private String buildingName;
    private String applyUserName;
}