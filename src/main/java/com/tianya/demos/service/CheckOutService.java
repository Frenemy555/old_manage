package com.tianya.demos.service;

import com.tianya.demos.pojo.entity.CheckOut;
import com.tianya.demos.pojo.entity.Result;

import java.util.List;

public interface CheckOutService {
    // 提交退住申请
    Result<String> apply(CheckOut checkOut);
    // 修改退住申请
    Result<String> update(CheckOut checkOut);
    // 删除退住申请
    Result<String> delete(Long id);
    // 根据id查询退住申请
    Result<CheckOut> getById(Long id);
    // 查询所有退住申请列表
    Result<List<CheckOut>> list();
    // 审批退住申请（1通过2驳回），通过时更新床位状态为空闲
    Result<String> approve(Long id, Integer status);
}
