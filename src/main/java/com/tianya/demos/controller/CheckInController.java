package com.tianya.demos.controller;

import com.tianya.demos.pojo.entity.CheckIn;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkIn")
public class CheckInController {

    @Autowired
    private CheckInService checkInService;

    // 提交入住申请
    @PostMapping
    public Result<String> apply(@RequestBody CheckIn checkIn){
        return checkInService.apply(checkIn);
    }

    // 修改入住申请
    @PutMapping
    public Result<String> update(@RequestBody CheckIn checkIn){
        return checkInService.update(checkIn);
    }

    // 删除入住申请
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Long id){
        return checkInService.delete(id);
    }

    // 根据id查询入住申请详情
    @GetMapping("/{id}")
    public Result<CheckIn> info(@PathVariable Long id){
        return checkInService.getById(id);
    }

    // 查询所有入住申请列表
    @GetMapping
    public Result<List<CheckIn>> list(){
        return checkInService.list();
    }

    // 审批入住申请（1通过2驳回）
    @PutMapping("/{id}/approve")
    public Result<String> approve(@PathVariable Long id, @RequestParam Integer status){
        return checkInService.approve(id, status);
    }
}
