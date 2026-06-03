package com.tianya.demos.service;

import com.tianya.demos.pojo.entity.Reservation;
import com.tianya.demos.pojo.entity.Result;

import java.util.List;

public interface ReservationService {
    // 新增预约
    Result<String> add(Reservation reservation);
    // 修改预约信息
    Result<String> update(Reservation reservation);
    // 删除预约
    Result<String> delete(Long id);
    // 根据id查询预约
    Result<Reservation> getById(Long id);
    // 查询所有预约
    Result<List<Reservation>> list();
    // 确认或取消预约（1已确认2取消）
    Result<String> confirm(Long id, Integer status);
}
