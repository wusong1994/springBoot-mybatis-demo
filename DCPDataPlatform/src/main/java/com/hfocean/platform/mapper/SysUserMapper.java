package com.hfocean.platform.mapper;

import com.hfocean.platform.core.mapper.BaseMapper;
import com.hfocean.platform.core.po.SysUserPo;
import com.hfocean.platform.dto.SysUserDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysUserMapper extends BaseMapper<SysUserPo> {

    @Select("select * from sys_user where user_id = #{userId}")
    SysUserPo findByUserId(Long userId);

    SysUserDTO selectByUserId(@Param("userId") Long userId);
}
