package com.tianya.demos.pojo.entity;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CheckOut {
    private Long id;
    private Long elderlyId;
    private Long bedId;
    private LocalDateTime checkOutTime;
    private Long applyUserId;
    private String reason;
    private Integer status;//0待审1通过2驳回
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}