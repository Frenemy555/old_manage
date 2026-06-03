package com.tianya.demos.controller;

import com.tianya.demos.pojo.entity.Building;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    // 新增楼栋
    @PostMapping
    public Result<String> add(@RequestBody Building building){
        return buildingService.add(building);
    }

    // 修改楼栋信息
    @PutMapping
    public Result<String> update(@RequestBody Building building){
        return buildingService.update(building);
    }

    // 删除楼栋
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Long id){
        return buildingService.delete(id);
    }

    // 根据id查询楼栋详情
    @GetMapping("/{id}")
    public Result<Building> info(@PathVariable Long id){
        return buildingService.getById(id);
    }

    // 查询所有楼栋列表
    @GetMapping
    public Result<List<Building>> list(){
        return buildingService.list();
    }
}
