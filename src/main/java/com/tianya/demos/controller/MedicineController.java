package com.tianya.demos.controller;

import com.tianya.demos.pojo.entity.Medicine;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    // 新增药品
    @PostMapping
    public Result<String> add(@RequestBody Medicine medicine){
        return medicineService.add(medicine);
    }

    // 修改药品信息
    @PutMapping
    public Result<String> update(@RequestBody Medicine medicine){
        return medicineService.update(medicine);
    }

    // 删除药品
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Long id){
        return medicineService.delete(id);
    }

    // 根据id查询药品详情
    @GetMapping("/{id}")
    public Result<Medicine> info(@PathVariable Long id){
        return medicineService.getById(id);
    }

    // 查询所有药品列表
    @GetMapping
    public Result<List<Medicine>> list(){
        return medicineService.list();
    }

    // 根据药品名称模糊查询
    @GetMapping("/search")
    public Result<List<Medicine>> search(@RequestParam String medicineName){
        return medicineService.searchByName(medicineName);
    }
}
