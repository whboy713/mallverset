package com.cowcow.mallverset.manager.controller;

import com.cowcow.mallverset.manager.service.SysUserService;
import com.cowcow.mallverset.model.dto.system.LoginDto;
import com.cowcow.mallverset.model.vo.common.Result;
import com.cowcow.mallverset.model.vo.common.ResultCodeEnum;
import com.cowcow.mallverset.model.vo.system.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/system/index")
public class IndexController {

    @Autowired
    private SysUserService sysUserService ;

    @PostMapping(value = "login")
    public Result<LoginVo> login(@RequestBody LoginDto loginDto) {
        LoginVo loginVo = sysUserService.login(loginDto) ;
        return Result.build(loginVo , ResultCodeEnum.SUCCESS) ;
    }

}
