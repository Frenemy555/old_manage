package com.tianya.demos.service.serviceImpl;

import com.tianya.demos.mapper.BuildingMapper;
import com.tianya.demos.pojo.entity.Building;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    // 新增楼栋：将楼栋信息插入数据库
    @Override
    public Result<String> add(Building building) {
        buildingMapper.insert(building);
        return Result.success("添加成功");
    }

    // 修改楼栋信息：根据id更新楼栋数据
    @Override
    public Result<String> update(Building building) {
        buildingMapper.updateById(building);
        return Result.success("修改成功");
    }

    // 删除楼栋：根据id逻辑删除楼栋
    @Override
    public Result<String> delete(Long id) {
        buildingMapper.deleteById(id);
        return Result.success("删除成功");
    }

    // 根据id查询楼栋：返回楼栋详情
    @Override
    public Result<Building> getById(Long id) {
        Building building = buildingMapper.selectById(id);
        if(building == null){
            return Result.error("楼栋不存在");
        }
        return Result.success(building);
    }

    // 查询所有楼栋：返回楼栋列表
    @Override
    public Result<List<Building>> list() {
        return Result.success(buildingMapper.selectAll());
    }
}
