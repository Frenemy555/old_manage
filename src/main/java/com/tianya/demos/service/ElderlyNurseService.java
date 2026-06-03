package com.tianya.demos.service;

import com.tianya.demos.pojo.entity.ElderlyNurse;
import com.tianya.demos.pojo.entity.Result;

import java.util.List;

public interface ElderlyNurseService {
    // 新增护理记录
    Result<String> add(ElderlyNurse elderlyNurse);
    // 修改护理记录
    Result<String> update(ElderlyNurse elderlyNurse);
    // 删除护理记录
    Result<String> delete(Long id);
    // 根据id查询护理记录
    Result<ElderlyNurse> getById(Long id);
    // 查询所有护理记录
    Result<List<ElderlyNurse>> list();
    // 根据老人id查询护理记录
    Result<List<ElderlyNurse>> listByElderlyId(Long elderlyId);
}
