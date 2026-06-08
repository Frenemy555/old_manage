package com.tianya.demos.service.serviceImpl;

import com.tianya.demos.mapper.SysUserMapper;
import com.tianya.demos.pojo.entity.SysUser;
import com.tianya.demos.service.SysUserService;
import com.tianya.demos.utils.Md5Util;
import com.tianya.demos.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper userMapper;

    // 根据用户名查询
    @Override
    public SysUser getByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    // 注册
    @Override
    public void register(String username, String password) {
        String md5String = Md5Util.getMD5String(password);
        SysUser user = new SysUser();
        user.setUsername(username);
        user.setPassword(md5String);
        user.setStatus(1);
        user.setIsDeleted(0);
        userMapper.insert(user);
    }

    // 查询用户详细信息
    @Override
    public SysUser userInfo() {
        Map<String, Object> claims = ThreadLocalUtil.get();
        Long id = Long.valueOf(claims.get("id").toString());
        SysUser user = userMapper.selectById(id);
        if (user != null) {
            user.setPassword(null);
        }
        return user;
    }

    // 更新用户基本信息
    @Override
    public void update(SysUser user) {
        userMapper.updateById(user);
    }

    // 更新用户密码
    @Override
    public void updatePwd(String newPwd) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        Long id = Long.valueOf(claims.get("id").toString());
        String pwd = Md5Util.getMD5String(newPwd);
        userMapper.updatePassword(id, pwd);
    }

    // 查询所有用户
    @Override
    public List<SysUser> list() {
        return userMapper.selectAll();
    }

    // 删除用户
    @Override
    public void delete(Long id) {
        userMapper.deleteById(id);
    }

    // 修改密码
    @Override
    public void updatePassword(Long userId, String oldPassword, String newPassword) {
        SysUser user = userMapper.selectById(userId);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        String oldMd5 = Md5Util.getMD5String(oldPassword);
        if (!oldMd5.equals(user.getPassword())) {
            throw new RuntimeException("原密码错误");
        }
        String newMd5 = Md5Util.getMD5String(newPassword);
        userMapper.updatePassword(userId, newMd5);
    }

    // 获取密码
    @Override
    public String getpwd() {
        Map<String, Object> claims = ThreadLocalUtil.get();
        Long id = Long.valueOf(claims.get("id").toString());
        SysUser user = userMapper.selectById(id);
        return user.getPassword();
    }
}
