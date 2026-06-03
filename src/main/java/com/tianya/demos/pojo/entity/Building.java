package com.tianya.demos.pojo.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Building {
    private Long id;
    private String buildingName;
    private Integer sort;
    private String remark;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}