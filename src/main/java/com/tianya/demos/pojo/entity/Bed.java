package com.tianya.demos.pojo.entity;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Bed {
    private Long id;
    private Long roomId;//逻辑外键-room.id
    private String bedName;
    private Integer status;//0空闲1入住2维修
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}