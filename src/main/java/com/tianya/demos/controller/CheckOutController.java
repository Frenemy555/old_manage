package com.tianya.demos.controller;

import com.tianya.demos.pojo.entity.CheckOut;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkOut")
public class CheckOutController {

    @Autowired
    private CheckOutService checkOutService;

    // 提交退住申请
    @PostMapping
    public Result<String> apply(@RequestBody CheckOut checkOut){
        return checkOutService.apply(checkOut);
    }

    // 修改退住申请
    @PutMapping
    public Result<String> update(@RequestBody CheckOut checkOut){
        return checkOutService.update(checkOut);
    }

    // 删除退住申请
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Long id){
        return checkOutService.delete(id);
    }

    // 根据id查询退住申请详情
    @GetMapping("/{id}")
    public Result<CheckOut> info(@PathVariable Long id){
        return checkOutService.getById(id);
    }

    // 查询所有退住申请列表
    @GetMapping
    public Result<List<CheckOut>> list(){
        return checkOutService.list();
    }

    // 审批退住申请（1通过2驳回）
    @PutMapping("/{id}/approve")
    public Result<String> approve(@PathVariable Long id, @RequestParam Integer status){
        return checkOutService.approve(id, status);
    }
}
