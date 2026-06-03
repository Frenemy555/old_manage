package com.tianya.demos.service.serviceImpl;
import com.tianya.demos.mapper.SysUserMapper;
import com.tianya.demos.pojo.dto.LoginDTO;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.pojo.entity.SysUser;
import com.tianya.demos.service.SysUserService;
import com.tianya.demos.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    // 用户登录：验证用户名密码，返回JWT令牌
    @Override
    public Result<String> login(LoginDTO dto) {
        SysUser user = userMapper.selectByUsername(dto.getUsername());
        if(user == null){
            return Result.error("账号不存在");
        }
        //md5比对密码
        String md5Pwd = DigestUtils.md5DigestAsHex(dto.getPassword().getBytes());
        if(!md5Pwd.equals(user.getPassword())){
            return Result.error("密码错误");
        }
        if(user.getStatus() == 0){
            return Result.error("账号已被禁用");
        }
        String token = JwtUtil.genToken(user.getId());
        return Result.success(token);
    }

    // 用户注册：校验用户名唯一性，密码MD5加密后入库
    @Override
    public Result<String> register(SysUser user) {
        //校验用户名是否存在
        SysUser exist = userMapper.selectByUsername(user.getUsername());
        if(exist != null){
            return Result.error("用户名已被注册");
        }
        //密码加密
        String md5 = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5);
        user.setStatus(1);
        user.setIsDeleted(0);
        userMapper.insert(user);
        return Result.success("注册成功");
    }

    // 查询个人信息：根据用户ID查询并隐藏密码字段
    @Override
    public Result<SysUser> getInfo(Long userId) {
        SysUser user = userMapper.selectById(userId);
        if(user == null){
            return Result.error("用户不存在");
        }
        user.setPassword(null); //密码不返回前端
        return Result.success(user);
    }

    // 修改个人信息：更新用户资料（不修改密码）
    @Override
    public Result<String> updateUser(SysUser user) {
        userMapper.updateById(user);
        return Result.success("修改成功");
    }

    // 查询所有用户：管理员使用，返回用户列表（不含密码）
    @Override
    public Result<List<SysUser>> list() {
        List<SysUser> users = userMapper.selectAll();
        return Result.success(users);
    }

    // 删除用户：根据id逻辑删除用户
    @Override
    public Result<String> delete(Long id) {
        userMapper.deleteById(id);
        return Result.success("删除成功");
    }

    // 修改密码：验证旧密码正确后更新为新密码
    @Override
    public Result<String> updatePassword(Long userId, String oldPassword, String newPassword) {
        SysUser user = userMapper.selectById(userId);
        if(user == null){
            return Result.error("用户不存在");
        }
        String oldMd5 = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
        if(!oldMd5.equals(user.getPassword())){
            return Result.error("原密码错误");
        }
        String newMd5 = DigestUtils.md5DigestAsHex(newPassword.getBytes());
        userMapper.updatePassword(userId, newMd5);
        return Result.success("密码修改成功");
    }
}
