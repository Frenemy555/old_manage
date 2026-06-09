package com.tianya.demos.controller;

import com.tianya.demos.mapper.SysUserMapper;
import com.tianya.demos.pojo.entity.Result;
import com.tianya.demos.pojo.entity.SysUser;
import com.tianya.demos.service.SysUserService;
import com.tianya.demos.utils.JwtUtil;
import com.tianya.demos.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Validated
public class SysUserController {

    @Autowired
    private SysUserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 新增用户（管理员在用户管理中新增）
    @PostMapping("/register")
    public Result register(@RequestBody SysUser user) {
        SysUser u = userService.getByUsername(user.getUsername());
        if (u == null) {
            userService.register(user);
            return Result.success();
        } else {
            return Result.error("该用户名已被占用");
        }
    }

    // 登录
    @PostMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password) {
        SysUser loginUser = userService.getByUsername(username);
        if (loginUser == null) {
            return Result.error("用户名错误");
        } else {
            if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
                if (loginUser.getStatus() == 0) {
                    return Result.error("账号已被禁用");
                }
                Map<String, Object> claims = new HashMap<>();
                claims.put("id", loginUser.getId());
                claims.put("username", loginUser.getUsername());
                String token = JwtUtil.genToken(claims);
                ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
                operations.set(token, token, 12, TimeUnit.HOURS);
                return Result.success(token);
            }
            return Result.error("密码错误");
        }
    }

    // 获取用户详细信息
    @GetMapping("/userInfo")
    public Result<SysUser> userInfo() {
        SysUser user = userService.userInfo();
        return Result.success(user);
    }

    // 更新用户基本信息
    @PutMapping("/update")
    public Result update(@RequestBody @Validated SysUser user) {
        userService.update(user);
        return Result.success();
    }

    // 更新用户密码
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String, String> params) {
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)) {
            return Result.error("缺少参数");
        }
        if (!newPwd.equals(rePwd)) {
            return Result.error("两次填写的新密码不一样");
        }
        String userPwd = userService.getpwd();
        if (!Md5Util.getMD5String(oldPwd).equals(userPwd)) {
            return Result.error("原密码错误");
        }
        if (oldPwd.equals(newPwd)) {
            return Result.error("新密码与原密码相同");
        }
        userService.updatePwd(newPwd);
        return Result.success();
    }

    // 查询所有用户（管理员使用）
    @GetMapping("/list")
    public Result<List<SysUser>> list() {
        List<SysUser> users = userService.list();
        return Result.success(users);
    }

    // 根据id删除用户
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        userService.delete(id);
        return Result.success();
    }

    // 修改当前登录用户密码
    @PutMapping("/password")
    public Result updatePassword(@RequestHeader("token") String token,
                                  @RequestParam String oldPassword,
                                  @RequestParam String newPassword) {
        Long userId = JwtUtil.getUserId(token);
        userService.updatePassword(userId, oldPassword, newPassword);
        return Result.success();
    }
}
