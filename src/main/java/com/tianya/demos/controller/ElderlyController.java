package com.tianya.demos.controller;

import com.tianya.demos.pojo.entity.Elderly;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.ElderlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elderly")
public class ElderlyController {

    @Autowired
    private ElderlyService elderlyService;

    // 新增老人档案
    @PostMapping
    public Result<String> add(@RequestBody Elderly elderly){
        return elderlyService.add(elderly);
    }

    // 修改老人档案
    @PutMapping
    public Result<String> update(@RequestBody Elderly elderly){
        return elderlyService.update(elderly);
    }

    // 删除老人档案
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Long id){
        return elderlyService.delete(id);
    }

    // 根据id查询老人档案详情
    @GetMapping("/{id}")
    public Result<Elderly> info(@PathVariable Long id){
        return elderlyService.getById(id);
    }

    // 查询所有老人档案列表
    @GetMapping
    public Result<List<Elderly>> list(){
        return elderlyService.list();
    }

    // 根据姓名模糊查询老人档案
    @GetMapping("/search")
    public Result<List<Elderly>> search(@RequestParam String name){
        return elderlyService.searchByName(name);
    }
}
