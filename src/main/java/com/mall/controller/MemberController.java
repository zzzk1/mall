package com.mall.controller;

import com.mall.common.api.CommonResult;
import com.mall.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = "MemberService")
@Controller
@RestController
@RequestMapping("/sso")
public class MemberController {
    @Autowired
    MemberService memberService;

    @ApiParam("获取验证码")
    @PostMapping("/generateAuthCode")
    public CommonResult generateAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiParam("检验验证码")
    @PostMapping("/verifyAuthCode")
    public CommonResult verifyAuthCode(@RequestParam String telephone, @RequestParam String code) {
        return memberService.verifyAuthCode(telephone, code);
    }
}
