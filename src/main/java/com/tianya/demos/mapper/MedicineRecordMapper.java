package com.tianya.demos.mapper;

import com.tianya.demos.pojo.entity.MedicineRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MedicineRecordMapper {
    // 新增用药记录
    int insert(MedicineRecord medicineRecord);
    // 修改用药记录
    int updateById(MedicineRecord medicineRecord);
    // 根据id删除用药记录（逻辑删除）
    int deleteById(Long id);
    // 根据id查询用药记录
    MedicineRecord selectById(Long id);
    // 查询所有用药记录（含关联信息）
    List<MedicineRecord> selectAll();
    // 根据老人id查询用药记录
    List<MedicineRecord> selectByElderlyId(Long elderlyId);
}
