package com.tianya.demos.mapper;

import com.tianya.demos.pojo.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper {
    // 根据用户名查询用户
    SysUser selectByUsername(String username);
    // 根据id查询
    SysUser selectById(Long id);
    // 新增用户(注册)
    int insert(SysUser user);
    // 修改用户信息
    int updateById(SysUser user);
    // 查询所有用户（管理员使用）
    List<SysUser> selectAll();
    // 根据id删除用户（逻辑删除）
    int deleteById(Long id);
    // 修改密码
    int updatePassword(@Param("userId") Long userId,@Param("password") String password);
}
