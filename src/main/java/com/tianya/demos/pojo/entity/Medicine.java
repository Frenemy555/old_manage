package com.tianya.demos.pojo.entity;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Medicine {
    private Long id;
    private String medicineName;
    private String spec;
    private Integer stock;
    private String unit;
    private BigDecimal price;
    private LocalDate produceDate;
    private LocalDate expireDate;
    private Integer status;//0下架1正常
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}