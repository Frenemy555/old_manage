package com.tianya.demos.controller;

import com.tianya.demos.pojo.entity.NurseItem;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.NurseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurseItem")
public class NurseItemController {

    @Autowired
    private NurseItemService nurseItemService;

    // 新增护理项目
    @PostMapping
    public Result<String> add(@RequestBody NurseItem nurseItem){
        return nurseItemService.add(nurseItem);
    }

    // 修改护理项目
    @PutMapping
    public Result<String> update(@RequestBody NurseItem nurseItem){
        return nurseItemService.update(nurseItem);
    }

    // 删除护理项目
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Long id){
        return nurseItemService.delete(id);
    }

    // 根据id查询护理项目详情
    @GetMapping("/{id}")
    public Result<NurseItem> info(@PathVariable Long id){
        return nurseItemService.getById(id);
    }

    // 查询所有护理项目列表
    @GetMapping
    public Result<List<NurseItem>> list(){
        return nurseItemService.list();
    }
}
