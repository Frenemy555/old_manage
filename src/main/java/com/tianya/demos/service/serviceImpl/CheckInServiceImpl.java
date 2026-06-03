package com.tianya.demos.service.serviceImpl;

import com.tianya.demos.mapper.BedMapper;
import com.tianya.demos.mapper.CheckInMapper;
import com.tianya.demos.pojo.entity.CheckIn;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    private CheckInMapper checkInMapper;
    @Autowired
    private BedMapper bedMapper;

    // 提交入住申请：状态默认为0（待审批），插入数据库
    @Override
    public Result<String> apply(CheckIn checkIn) {
        checkIn.setStatus(0);
        checkInMapper.insert(checkIn);
        return Result.success("申请提交成功");
    }

    // 修改入住申请：根据id更新申请信息
    @Override
    public Result<String> update(CheckIn checkIn) {
        checkInMapper.updateById(checkIn);
        return Result.success("修改成功");
    }

    // 删除入住申请：根据id逻辑删除
    @Override
    public Result<String> delete(Long id) {
        checkInMapper.deleteById(id);
        return Result.success("删除成功");
    }

    // 根据id查询入住申请：返回申请详情
    @Override
    public Result<CheckIn> getById(Long id) {
        CheckIn checkIn = checkInMapper.selectById(id);
        if(checkIn == null){
            return Result.error("记录不存在");
        }
        return Result.success(checkIn);
    }

    // 查询所有入住申请：返回申请列表（含老人、床位、房间、楼栋、申请人名称）
    @Override
    public Result<List<CheckIn>> list() {
        return Result.success(checkInMapper.selectAll());
    }

    // 审批入住申请：1通过则更新床位状态为入住，2驳回仅修改状态
    @Override
    @Transactional
    public Result<String> approve(Long id, Integer status) {
        CheckIn checkIn = checkInMapper.selectById(id);
        if(checkIn == null){
            return Result.error("记录不存在");
        }
        if(checkIn.getStatus() != 0){
            return Result.error("该申请已处理");
        }
        checkInMapper.updateStatus(id, status);
        if(status == 1){
            // 审批通过，更新床位状态为入住
            bedMapper.updateStatus(checkIn.getBedId(), 1);
        }
        return Result.success("审批完成");
    }
}
