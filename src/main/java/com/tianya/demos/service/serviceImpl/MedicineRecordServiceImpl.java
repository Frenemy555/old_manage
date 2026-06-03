package com.tianya.demos.service.serviceImpl;

import com.tianya.demos.mapper.MedicineMapper;
import com.tianya.demos.mapper.MedicineRecordMapper;
import com.tianya.demos.pojo.entity.Medicine;
import com.tianya.demos.pojo.entity.MedicineRecord;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.MedicineRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicineRecordServiceImpl implements MedicineRecordService {

    @Autowired
    private MedicineRecordMapper medicineRecordMapper;
    @Autowired
    private MedicineMapper medicineMapper;

    // 新增用药记录：校验药品存在且库存充足，扣减库存后插入记录
    @Override
    @Transactional
    public Result<String> add(MedicineRecord medicineRecord) {
        Medicine medicine = medicineMapper.selectById(medicineRecord.getMedicineId());
        if(medicine == null){
            return Result.error("药品不存在");
        }
        if(medicine.getStock() <= 0){
            return Result.error("药品库存不足");
        }
        medicineRecordMapper.insert(medicineRecord);
        // 扣减库存
        medicineMapper.updateStock(medicine.getId(), medicine.getStock() - 1);
        return Result.success("添加成功");
    }

    // 修改用药记录：根据id更新用药记录数据
    @Override
    public Result<String> update(MedicineRecord medicineRecord) {
        medicineRecordMapper.updateById(medicineRecord);
        return Result.success("修改成功");
    }

    // 删除用药记录：根据id逻辑删除
    @Override
    public Result<String> delete(Long id) {
        medicineRecordMapper.deleteById(id);
        return Result.success("删除成功");
    }

    // 根据id查询用药记录：返回用药记录详情
    @Override
    public Result<MedicineRecord> getById(Long id) {
        MedicineRecord record = medicineRecordMapper.selectById(id);
        if(record == null){
            return Result.error("记录不存在");
        }
        return Result.success(record);
    }

    // 查询所有用药记录：返回用药记录列表（含老人、药品、操作人名称）
    @Override
    public Result<List<MedicineRecord>> list() {
        return Result.success(medicineRecordMapper.selectAll());
    }

    // 根据老人id查询用药记录：返回该老人的所有用药记录
    @Override
    public Result<List<MedicineRecord>> listByElderlyId(Long elderlyId) {
        return Result.success(medicineRecordMapper.selectByElderlyId(elderlyId));
    }
}
