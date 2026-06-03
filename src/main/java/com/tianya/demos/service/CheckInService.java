package com.tianya.demos.service;

import com.tianya.demos.pojo.entity.CheckIn;
import com.tianya.demos.pojo.entity.Result;

import java.util.List;

public interface CheckInService {
    // 提交入住申请
    Result<String> apply(CheckIn checkIn);
    // 修改入住申请
    Result<String> update(CheckIn checkIn);
    // 删除入住申请
    Result<String> delete(Long id);
    // 根据id查询入住申请
    Result<CheckIn> getById(Long id);
    // 查询所有入住申请列表
    Result<List<CheckIn>> list();
    // 审批入住申请（1通过2驳回），通过时更新床位状态为入住
    Result<String> approve(Long id, Integer status);
}
