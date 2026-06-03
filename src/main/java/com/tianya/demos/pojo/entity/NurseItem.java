package com.tianya.demos.pojo.entity;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class NurseItem {
    private Long id;
    private String itemName;
    private BigDecimal price;
    private String content;
    private Integer status;//0禁用1启用
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}