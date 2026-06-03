package com.tianya.demos.service.serviceImpl;

import com.tianya.demos.mapper.ElderlyNurseMapper;
import com.tianya.demos.pojo.entity.ElderlyNurse;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.ElderlyNurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElderlyNurseServiceImpl implements ElderlyNurseService {

    @Autowired
    private ElderlyNurseMapper elderlyNurseMapper;

    // 新增护理记录：将护理记录插入数据库
    @Override
    public Result<String> add(ElderlyNurse elderlyNurse) {
        elderlyNurseMapper.insert(elderlyNurse);
        return Result.success("添加成功");
    }

    // 修改护理记录：根据id更新护理记录数据
    @Override
    public Result<String> update(ElderlyNurse elderlyNurse) {
        elderlyNurseMapper.updateById(elderlyNurse);
        return Result.success("修改成功");
    }

    // 删除护理记录：根据id逻辑删除
    @Override
    public Result<String> delete(Long id) {
        elderlyNurseMapper.deleteById(id);
        return Result.success("删除成功");
    }

    // 根据id查询护理记录：返回护理记录详情（含老人、护理项目、护理人员名称）
    @Override
    public Result<ElderlyNurse> getById(Long id) {
        ElderlyNurse en = elderlyNurseMapper.selectById(id);
        if(en == null){
            return Result.error("记录不存在");
        }
        return Result.success(en);
    }

    // 查询所有护理记录：返回护理记录列表
    @Override
    public Result<List<ElderlyNurse>> list() {
        return Result.success(elderlyNurseMapper.selectAll());
    }

    // 根据老人id查询护理记录：返回该老人的所有护理记录
    @Override
    public Result<List<ElderlyNurse>> listByElderlyId(Long elderlyId) {
        return Result.success(elderlyNurseMapper.selectByElderlyId(elderlyId));
    }
}
