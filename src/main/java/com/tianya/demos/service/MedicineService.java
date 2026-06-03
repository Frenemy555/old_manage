package com.tianya.demos.service;

import com.tianya.demos.pojo.entity.Medicine;
import com.tianya.demos.pojo.entity.Result;

import java.util.List;

public interface MedicineService {
    // 新增药品
    Result<String> add(Medicine medicine);
    // 修改药品信息
    Result<String> update(Medicine medicine);
    // 删除药品
    Result<String> delete(Long id);
    // 根据id查询药品
    Result<Medicine> getById(Long id);
    // 查询所有药品
    Result<List<Medicine>> list();
    // 根据药品名称模糊查询
    Result<List<Medicine>> searchByName(String medicineName);
}
