package com.tianya.demos.pojo.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Room {
    private Long id;
    private Long buildingId;//逻辑外键-building.id
    private String roomName;
    private Integer bedCount;
    private String roomType;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}