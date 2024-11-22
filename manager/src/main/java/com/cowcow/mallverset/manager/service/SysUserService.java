package com.cowcow.mallverset.manager.service;

import com.cowcow.mallverset.model.dto.system.LoginDto;
import com.cowcow.mallverset.model.vo.system.LoginVo;

public interface SysUserService {

    /**
     * 根据用户名查询用户数据
     * @return
     */
    public abstract LoginVo login(LoginDto loginDto) ;

}
