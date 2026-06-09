package com.tianya.demos.pojo.entity;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Reservation {
    private Long id;
    private Long elderlyId;
    private String reservationUser;
    private String phone;
    private LocalDateTime reservationTime;
    private Integer type;//1探视2体验
    private Integer status;//0待确认1已确认2取消
    private String remark;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;

    // 关联字段
    private String elderlyName;
}