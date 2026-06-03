package com.tianya.demos.service.serviceImpl;

import com.tianya.demos.mapper.BedMapper;
import com.tianya.demos.pojo.entity.Bed;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedMapper bedMapper;

    // 新增床位：默认状态为空闲，插入数据库
    @Override
    public Result<String> add(Bed bed) {
        bed.setStatus(0);
        bedMapper.insert(bed);
        return Result.success("添加成功");
    }

    // 修改床位信息：根据id更新床位数据
    @Override
    public Result<String> update(Bed bed) {
        bedMapper.updateById(bed);
        return Result.success("修改成功");
    }

    // 删除床位：根据id逻辑删除床位
    @Override
    public Result<String> delete(Long id) {
        bedMapper.deleteById(id);
        return Result.success("删除成功");
    }

    // 根据id查询床位：返回床位详情
    @Override
    public Result<Bed> getById(Long id) {
        Bed bed = bedMapper.selectById(id);
        if(bed == null){
            return Result.error("床位不存在");
        }
        return Result.success(bed);
    }

    // 查询所有床位：返回床位列表（含房间、楼栋名称）
    @Override
    public Result<List<Bed>> list() {
        return Result.success(bedMapper.selectAll());
    }

    // 根据房间id查询床位：返回该房间下的所有床位
    @Override
    public Result<List<Bed>> listByRoomId(Long roomId) {
        return Result.success(bedMapper.selectByRoomId(roomId));
    }

    // 修改床位状态：更新床位状态（0空闲1入住2维修）
    @Override
    public Result<String> updateStatus(Long id, Integer status) {
        bedMapper.updateStatus(id, status);
        return Result.success("状态更新成功");
    }
}
