package com.tianya.demos.service.serviceImpl;

import com.tianya.demos.mapper.MedicineMapper;
import com.tianya.demos.pojo.entity.Medicine;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineMapper medicineMapper;

    // 新增药品：默认状态为正常，插入数据库
    @Override
    public Result<String> add(Medicine medicine) {
        medicine.setStatus(1);
        medicineMapper.insert(medicine);
        return Result.success("添加成功");
    }

    // 修改药品信息：根据id更新药品数据
    @Override
    public Result<String> update(Medicine medicine) {
        medicineMapper.updateById(medicine);
        return Result.success("修改成功");
    }

    // 删除药品：根据id逻辑删除
    @Override
    public Result<String> delete(Long id) {
        medicineMapper.deleteById(id);
        return Result.success("删除成功");
    }

    // 根据id查询药品：返回药品详情
    @Override
    public Result<Medicine> getById(Long id) {
        Medicine medicine = medicineMapper.selectById(id);
        if(medicine == null){
            return Result.error("药品不存在");
        }
        return Result.success(medicine);
    }

    // 查询所有药品：返回药品列表
    @Override
    public Result<List<Medicine>> list() {
        return Result.success(medicineMapper.selectAll());
    }

    // 根据药品名称模糊查询药品
    @Override
    public Result<List<Medicine>> searchByName(String medicineName) {
        return Result.success(medicineMapper.selectByName(medicineName));
    }
}
