package com.mall.service;

import com.mall.common.api.CommonResult;

public interface MemberService {
    CommonResult generateAuthCode(String telephone);

    CommonResult verifyAuthCode(String telephone, String authCode);
}
