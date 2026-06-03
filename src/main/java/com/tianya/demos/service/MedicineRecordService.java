package com.tianya.demos.service;

import com.tianya.demos.pojo.entity.MedicineRecord;
import com.tianya.demos.pojo.entity.Result;

import java.util.List;

public interface MedicineRecordService {
    // 新增用药记录（自动扣减库存）
    Result<String> add(MedicineRecord medicineRecord);
    // 修改用药记录
    Result<String> update(MedicineRecord medicineRecord);
    // 删除用药记录
    Result<String> delete(Long id);
    // 根据id查询用药记录
    Result<MedicineRecord> getById(Long id);
    // 查询所有用药记录
    Result<List<MedicineRecord>> list();
    // 根据老人id查询用药记录
    Result<List<MedicineRecord>> listByElderlyId(Long elderlyId);
}
