package com.tianya.demos.service.serviceImpl;

import com.tianya.demos.mapper.BedMapper;
import com.tianya.demos.mapper.CheckOutMapper;
import com.tianya.demos.pojo.entity.CheckOut;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianya.demos.utils.ThreadLocalUtil;

import java.util.List;
import java.util.Map;

@Service
public class CheckOutServiceImpl implements CheckOutService {

    @Autowired
    private CheckOutMapper checkOutMapper;
    @Autowired
    private BedMapper bedMapper;

    // 提交退住申请：状态默认为0（待审批），插入数据库
    @Override
    public Result<String> apply(CheckOut checkOut) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        Long userId = Long.valueOf(claims.get("id").toString());
        checkOut.setApplyUserId(userId);
        checkOut.setStatus(0);
        checkOutMapper.insert(checkOut);
        return Result.success("申请提交成功");
    }

    // 修改退住申请：根据id更新申请信息
    @Override
    public Result<String> update(CheckOut checkOut) {
        checkOutMapper.updateById(checkOut);
        return Result.success("修改成功");
    }

    // 删除退住申请：根据id逻辑删除
    @Override
    public Result<String> delete(Long id) {
        checkOutMapper.deleteById(id);
        return Result.success("删除成功");
    }

    // 根据id查询退住申请：返回申请详情
    @Override
    public Result<CheckOut> getById(Long id) {
        CheckOut checkOut = checkOutMapper.selectById(id);
        if(checkOut == null){
            return Result.error("记录不存在");
        }
        return Result.success(checkOut);
    }

    // 查询所有退住申请：返回申请列表（含老人、床位、房间、楼栋、申请人名称）
    @Override
    public Result<List<CheckOut>> list() {
        return Result.success(checkOutMapper.selectAll());
    }

    // 审批退住申请：1通过则更新床位状态为空闲，2驳回仅修改状态
    @Override
    @Transactional
    public Result<String> approve(Long id, Integer status) {
        CheckOut checkOut = checkOutMapper.selectById(id);
        if(checkOut == null){
            return Result.error("记录不存在");
        }
        if(checkOut.getStatus() != 0){
            return Result.error("该申请已处理");
        }
        checkOutMapper.updateStatus(id, status);
        if(status == 1){
            // 审批通过，更新床位状态为空闲
            bedMapper.updateStatus(checkOut.getBedId(), 0);
        }
        return Result.success("审批完成");
    }
}
