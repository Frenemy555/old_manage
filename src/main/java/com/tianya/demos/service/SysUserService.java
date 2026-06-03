package com.tianya.demos.service;

import com.tianya.demos.pojo.dto.LoginDTO;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.pojo.entity.SysUser;

import java.util.List;

public interface SysUserService {
    // 用户登录
    Result<String> login(LoginDTO dto);
    // 用户注册
    Result<String> register(SysUser user);
    // 查询个人信息
    Result<SysUser> getInfo(Long userId);
    // 修改个人信息
    Result<String> updateUser(SysUser user);
    // 查询所有用户
    Result<List<SysUser>> list();
    // 删除用户
    Result<String> delete(Long id);
    // 修改密码
    Result<String> updatePassword(Long userId, String oldPassword, String newPassword);
}
