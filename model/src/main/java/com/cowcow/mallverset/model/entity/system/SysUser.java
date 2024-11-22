package com.cowcow.mallverset.model.entity.system;

import com.cowcow.mallverset.model.entity.base.BaseEntity;
import lombok.Data;

@Data
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private String userName;  // 该字段的属性名称和数据表字段不一致
    private String password;
    private String name;
    private String phone;
    private String avatar;
    private String description;
    private Integer status;

}
