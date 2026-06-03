package com.tianya.demos.pojo.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Elderly {
    private Long id;
    private String name;
    private Integer gender;//0女1男
    private Integer age;
    private String idCard;
    private String phone;
    private String address;
    private String healthStatus;
    private String familyName;
    private String familyPhone;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}