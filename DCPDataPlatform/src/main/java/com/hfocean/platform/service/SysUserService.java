package com.hfocean.platform.service;

import com.hfocean.platform.core.po.SysUserPo;
import com.hfocean.platform.dto.PageResultDTO;
import com.hfocean.platform.dto.SysUserDTO;
import com.hfocean.platform.request.PageRequest;

public interface SysUserService {

    int addUser(SysUserPo userPo);

    SysUserPo findByUserId(Long userId);

    SysUserDTO selectByUserId(Long userId);

    PageResultDTO findPage(PageRequest pageRequest);
}
