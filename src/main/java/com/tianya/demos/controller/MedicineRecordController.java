package com.tianya.demos.controller;

import com.tianya.demos.pojo.entity.MedicineRecord;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.MedicineRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicineRecord")
public class MedicineRecordController {

    @Autowired
    private MedicineRecordService medicineRecordService;

    // 新增用药记录（自动扣减库存）
    @PostMapping
    public Result<String> add(@RequestBody MedicineRecord medicineRecord){
        return medicineRecordService.add(medicineRecord);
    }

    // 修改用药记录
    @PutMapping
    public Result<String> update(@RequestBody MedicineRecord medicineRecord){
        return medicineRecordService.update(medicineRecord);
    }

    // 删除用药记录
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Long id){
        return medicineRecordService.delete(id);
    }

    // 根据id查询用药记录详情
    @GetMapping("/{id}")
    public Result<MedicineRecord> info(@PathVariable Long id){
        return medicineRecordService.getById(id);
    }

    // 查询所有用药记录列表，或根据老人id筛选
    @GetMapping
    public Result<List<MedicineRecord>> list(@RequestParam(required = false) Long elderlyId){
        if(elderlyId != null){
            return medicineRecordService.listByElderlyId(elderlyId);
        }
        return medicineRecordService.list();
    }
}
