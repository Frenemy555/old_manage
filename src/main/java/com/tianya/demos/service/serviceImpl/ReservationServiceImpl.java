package com.tianya.demos.service.serviceImpl;

import com.tianya.demos.mapper.ReservationMapper;
import com.tianya.demos.pojo.entity.Reservation;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;

    // 新增预约：状态默认为0（待确认），插入数据库
    @Override
    public Result<String> add(Reservation reservation) {
        reservation.setStatus(0);
        reservationMapper.insert(reservation);
        return Result.success("预约提交成功");
    }

    // 修改预约信息：根据id更新预约数据
    @Override
    public Result<String> update(Reservation reservation) {
        reservationMapper.updateById(reservation);
        return Result.success("修改成功");
    }

    // 删除预约：根据id逻辑删除
    @Override
    public Result<String> delete(Long id) {
        reservationMapper.deleteById(id);
        return Result.success("删除成功");
    }

    // 根据id查询预约：返回预约详情
    @Override
    public Result<Reservation> getById(Long id) {
        Reservation reservation = reservationMapper.selectById(id);
        if(reservation == null){
            return Result.error("记录不存在");
        }
        return Result.success(reservation);
    }

    // 查询所有预约：返回预约列表（含老人名称）
    @Override
    public Result<List<Reservation>> list() {
        return Result.success(reservationMapper.selectAll());
    }

    // 确认或取消预约：1已确认，2取消
    @Override
    public Result<String> confirm(Long id, Integer status) {
        Reservation reservation = reservationMapper.selectById(id);
        if(reservation == null){
            return Result.error("记录不存在");
        }
        if(reservation.getStatus() != 0){
            return Result.error("该预约已处理");
        }
        reservationMapper.updateStatus(id, status);
        return Result.success("处理成功");
    }
}
