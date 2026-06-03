package com.tianya.demos.service.serviceImpl;

import com.tianya.demos.mapper.ElderlyMapper;
import com.tianya.demos.pojo.entity.Elderly;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.ElderlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElderlyServiceImpl implements ElderlyService {

    @Autowired
    private ElderlyMapper elderlyMapper;

    // 新增老人档案：将老人信息插入数据库
    @Override
    public Result<String> add(Elderly elderly) {
        elderlyMapper.insert(elderly);
        return Result.success("添加成功");
    }

    // 修改老人档案：根据id更新老人数据
    @Override
    public Result<String> update(Elderly elderly) {
        elderlyMapper.updateById(elderly);
        return Result.success("修改成功");
    }

    // 删除老人档案：根据id逻辑删除
    @Override
    public Result<String> delete(Long id) {
        elderlyMapper.deleteById(id);
        return Result.success("删除成功");
    }

    // 根据id查询老人档案：返回老人详情
    @Override
    public Result<Elderly> getById(Long id) {
        Elderly elderly = elderlyMapper.selectById(id);
        if(elderly == null){
            return Result.error("老人档案不存在");
        }
        return Result.success(elderly);
    }

    // 查询所有老人档案：返回老人列表
    @Override
    public Result<List<Elderly>> list() {
        return Result.success(elderlyMapper.selectAll());
    }

    // 根据姓名模糊查询老人档案
    @Override
    public Result<List<Elderly>> searchByName(String name) {
        return Result.success(elderlyMapper.selectByName(name));
    }
}
