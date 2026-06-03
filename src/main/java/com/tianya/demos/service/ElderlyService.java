package com.tianya.demos.service;

import com.tianya.demos.pojo.entity.Elderly;
import com.tianya.demos.pojo.entity.Result;

import java.util.List;

public interface ElderlyService {
    // 新增老人档案
    Result<String> add(Elderly elderly);
    // 修改老人档案
    Result<String> update(Elderly elderly);
    // 删除老人档案
    Result<String> delete(Long id);
    // 根据id查询老人档案
    Result<Elderly> getById(Long id);
    // 查询所有老人档案
    Result<List<Elderly>> list();
    // 根据姓名模糊查询老人档案
    Result<List<Elderly>> searchByName(String name);
}
