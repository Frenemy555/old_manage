package com.tianya.demos.service;

import com.tianya.demos.pojo.entity.NurseItem;
import com.tianya.demos.pojo.entity.Result;

import java.util.List;

public interface NurseItemService {
    // 新增护理项目
    Result<String> add(NurseItem nurseItem);
    // 修改护理项目
    Result<String> update(NurseItem nurseItem);
    // 删除护理项目
    Result<String> delete(Long id);
    // 根据id查询护理项目
    Result<NurseItem> getById(Long id);
    // 查询所有护理项目
    Result<List<NurseItem>> list();
}
