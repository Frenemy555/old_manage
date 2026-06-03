package com.tianya.demos.service.serviceImpl;

import com.tianya.demos.mapper.NurseItemMapper;
import com.tianya.demos.pojo.entity.NurseItem;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.NurseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseItemServiceImpl implements NurseItemService {

    @Autowired
    private NurseItemMapper nurseItemMapper;

    // 新增护理项目：默认状态为启用，插入数据库
    @Override
    public Result<String> add(NurseItem nurseItem) {
        nurseItem.setStatus(1);
        nurseItemMapper.insert(nurseItem);
        return Result.success("添加成功");
    }

    // 修改护理项目：根据id更新护理项目数据
    @Override
    public Result<String> update(NurseItem nurseItem) {
        nurseItemMapper.updateById(nurseItem);
        return Result.success("修改成功");
    }

    // 删除护理项目：根据id逻辑删除
    @Override
    public Result<String> delete(Long id) {
        nurseItemMapper.deleteById(id);
        return Result.success("删除成功");
    }

    // 根据id查询护理项目：返回护理项目详情
    @Override
    public Result<NurseItem> getById(Long id) {
        NurseItem item = nurseItemMapper.selectById(id);
        if(item == null){
            return Result.error("护理项目不存在");
        }
        return Result.success(item);
    }

    // 查询所有护理项目：返回护理项目列表
    @Override
    public Result<List<NurseItem>> list() {
        return Result.success(nurseItemMapper.selectAll());
    }
}
