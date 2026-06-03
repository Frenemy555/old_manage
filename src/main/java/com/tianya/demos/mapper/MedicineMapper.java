package com.tianya.demos.mapper;

import com.tianya.demos.pojo.entity.Medicine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MedicineMapper {
    // 新增药品
    int insert(Medicine medicine);
    // 修改药品信息
    int updateById(Medicine medicine);
    // 根据id删除药品（逻辑删除）
    int deleteById(Long id);
    // 根据id查询药品
    Medicine selectById(Long id);
    // 查询所有药品
    List<Medicine> selectAll();
    // 根据药品名称模糊查询
    List<Medicine> selectByName(String medicineName);
    // 修改药品库存
    int updateStock(@Param("id") Long id, @Param("stock") Integer stock);
}
