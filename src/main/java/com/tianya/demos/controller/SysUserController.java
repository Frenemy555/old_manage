package com.tianya.demos.controller;
import com.tianya.demos.pojo.dto.LoginDTO;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.pojo.entity.SysUser;
import com.tianya.demos.service.SysUserService;
import com.tianya.demos.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    // 用户登录
    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginDTO dto){
        return userService.login(dto);
    }

    // 用户注册
    @PostMapping("/register")
    public Result<String> register(@RequestBody SysUser user){
        return userService.register(user);
    }

    // 查询当前登录用户信息（个人中心）
    @GetMapping
    public Result<SysUser> getUserInfo(@RequestHeader("token") String token){
        Long userId = JwtUtil.getUserId(token);
        return userService.getInfo(userId);
    }

    // 修改当前登录用户信息
    @PutMapping
    public Result<String> update(@RequestBody SysUser user, @RequestHeader("token") String token){
        Long uid = JwtUtil.getUserId(token);
        user.setId(uid);
        return userService.updateUser(user);
    }

    // 查询所有用户（管理员使用）
    @GetMapping("/list")
    public Result<List<SysUser>> list(){
        return userService.list();
    }

    // 根据id删除用户
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Long id){
        return userService.delete(id);
    }

    // 修改当前登录用户密码
    @PutMapping("/password")
    public Result<String> updatePassword(@RequestHeader("token") String token,
                                            @RequestParam String oldPassword,
                                            @RequestParam String newPassword){
        Long userId = JwtUtil.getUserId(token);
        return userService.updatePassword(userId, oldPassword, newPassword);
    }
}
