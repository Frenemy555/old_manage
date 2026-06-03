package com.tianya.demos.controller;

import com.tianya.demos.pojo.entity.ElderlyNurse;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.ElderlyNurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elderlyNurse")
public class ElderlyNurseController {

    @Autowired
    private ElderlyNurseService elderlyNurseService;

    // 新增护理记录
    @PostMapping
    public Result<String> add(@RequestBody ElderlyNurse elderlyNurse){
        return elderlyNurseService.add(elderlyNurse);
    }

    // 修改护理记录
    @PutMapping
    public Result<String> update(@RequestBody ElderlyNurse elderlyNurse){
        return elderlyNurseService.update(elderlyNurse);
    }

    // 删除护理记录
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Long id){
        return elderlyNurseService.delete(id);
    }

    // 根据id查询护理记录详情
    @GetMapping("/{id}")
    public Result<ElderlyNurse> info(@PathVariable Long id){
        return elderlyNurseService.getById(id);
    }

    // 查询所有护理记录列表，或根据老人id筛选
    @GetMapping
    public Result<List<ElderlyNurse>> list(@RequestParam(required = false) Long elderlyId){
        if(elderlyId != null){
            return elderlyNurseService.listByElderlyId(elderlyId);
        }
        return elderlyNurseService.list();
    }
}
