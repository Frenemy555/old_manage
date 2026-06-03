package com.tianya.demos.controller;

import com.tianya.demos.pojo.entity.Bed;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bed")
public class BedController {

    @Autowired
    private BedService bedService;

    // 新增床位
    @PostMapping
    public Result<String> add(@RequestBody Bed bed){
        return bedService.add(bed);
    }

    // 修改床位信息
    @PutMapping
    public Result<String> update(@RequestBody Bed bed){
        return bedService.update(bed);
    }

    // 删除床位
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Long id){
        return bedService.delete(id);
    }

    // 根据id查询床位详情
    @GetMapping("/{id}")
    public Result<Bed> info(@PathVariable Long id){
        return bedService.getById(id);
    }

    // 查询所有床位列表，或根据房间id筛选
    @GetMapping
    public Result<List<Bed>> list(@RequestParam(required = false) Long roomId){
        if(roomId != null){
            return bedService.listByRoomId(roomId);
        }
        return bedService.list();
    }

    // 修改床位状态（0空闲1入住2维修）
    @PutMapping("/{id}/status")
    public Result<String> updateStatus(@PathVariable Long id, @RequestParam Integer status){
        return bedService.updateStatus(id, status);
    }
}
