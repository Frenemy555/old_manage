package com.tianya.demos.service;

import com.tianya.demos.pojo.entity.SysUser;

import java.util.List;

public interface SysUserService {
    // 根据用户名查询
    SysUser getByUsername(String username);

    // 注册
    void register(String username, String password);

    // 获取用户详细信息
    SysUser userInfo();

    // 更新用户基本信息
    void update(SysUser user);

    // 更新用户密码
    void updatePwd(String newPwd);

    // 查询所有用户（管理员使用）
    List<SysUser> list();

    // 删除用户
    void delete(Long id);

    // 修改密码（带旧密码验证）
    void updatePassword(Long userId, String oldPassword, String newPassword);

    // 获取密码
    String getpwd();
}
