package com.tianya.demos.controller;

import com.tianya.demos.pojo.entity.Reservation;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // 新增预约
    @PostMapping
    public Result<String> add(@RequestBody Reservation reservation){
        return reservationService.add(reservation);
    }

    // 修改预约信息
    @PutMapping
    public Result<String> update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }

    // 删除预约
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Long id){
        return reservationService.delete(id);
    }

    // 根据id查询预约详情
    @GetMapping("/{id}")
    public Result<Reservation> info(@PathVariable Long id){
        return reservationService.getById(id);
    }

    // 查询所有预约列表
    @GetMapping
    public Result<List<Reservation>> list(){
        return reservationService.list();
    }

    // 确认或取消预约（1已确认2取消）
    @PutMapping("/{id}/confirm")
    public Result<String> confirm(@PathVariable Long id, @RequestParam Integer status){
        return reservationService.confirm(id, status);
    }
}
