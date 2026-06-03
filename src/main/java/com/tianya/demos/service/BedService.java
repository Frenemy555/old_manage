package com.tianya.demos.service;

import com.tianya.demos.pojo.entity.Bed;
import com.tianya.demos.pojo.entity.Result;

import java.util.List;

public interface BedService {
    // 新增床位
    Result<String> add(Bed bed);
    // 修改床位信息
    Result<String> update(Bed bed);
    // 删除床位
    Result<String> delete(Long id);
    // 根据id查询床位
    Result<Bed> getById(Long id);
    // 查询所有床位
    Result<List<Bed>> list();
    // 根据房间id查询床位
    Result<List<Bed>> listByRoomId(Long roomId);
    // 修改床位状态（0空闲1入住2维修）
    Result<String> updateStatus(Long id, Integer status);
}
