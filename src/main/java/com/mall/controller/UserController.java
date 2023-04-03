package com.mall.controller;

import com.mall.common.api.CommonPage;
import com.mall.common.api.CommonResult;
import com.mall.mbg.model.TUser;
import com.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;

@Api(tags = "UserController")
@Controller
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @ApiOperation("获取用户分页")
    @GetMapping("/get/pages")
    public CommonResult<CommonPage<TUser>> getPage(@RequestParam(value = "pageNum", defaultValue = "1")
                                                   @ApiParam("页码") int pageNum,
                                                   @RequestParam(value = "pageSize", defaultValue = "3")
                                                   @ApiParam("每页数量") int pageSize) {
        List<TUser> tUsers = service.getPageUser(pageNum, pageSize);
        return CommonResult.success(CommonPage.resultPage(tUsers));
    }

    @ApiOperation("获取用户")
    @GetMapping("/get/{id}")
    public CommonResult<TUser> getUser(@PathVariable int id) {
        TUser user = service.getUser(id);
        if (user != null) {
            return CommonResult.success(user);
        } else {
            return CommonResult.failed("用户不存在");
        }
    }

    @ApiOperation("获取用户列表")
    @GetMapping("/get")
    public CommonResult<List<TUser>> getAllUser() {
        List<TUser> userList = service.getAll();
        if (userList != null) {
            return CommonResult.success(userList);
        } else {
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("添加用户")
    @PostMapping("/add")
    public CommonResult addUser(@RequestBody TUser tUser) {
        int count = service.addUser(tUser);
        if (count == 1) {
            return CommonResult.success(tUser);
        } else {
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("根据id删除用户")
    @DeleteMapping("/delete/{id}")
    public CommonResult deleteUser(@PathVariable int id) {
        int count = service.deleteUser(id);
        if (count == 1) {
            return CommonResult.success("删除成功");
        } else {
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("根据id更新用户信息")
    @PutMapping("/update/{id}")
    public CommonResult updateUser(@PathVariable int id, @RequestBody TUser tUser) {
        int count = service.updateUser(id, tUser);
        if (count == 1) {
            return CommonResult.success(tUser);
        } else {
            return CommonResult.failed("操作失败");
        }
    }
}
