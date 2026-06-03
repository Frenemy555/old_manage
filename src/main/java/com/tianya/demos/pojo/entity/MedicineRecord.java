package com.tianya.demos.pojo.entity;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MedicineRecord {
    private Long id;
    private Long elderlyId;
    private Long medicineId;
    private String dosage;
    private LocalDateTime useTime;
    private Long operatorId;//操作人userid
    private String remark;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
}