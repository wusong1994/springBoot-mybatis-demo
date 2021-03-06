package com.hfocean.platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hfocean.platform.core.po.SysUserPo;
import com.hfocean.platform.core.util.PageUtils;
import com.hfocean.platform.dto.PageResultDTO;
import com.hfocean.platform.mapper.SysUserMapper;
import com.hfocean.platform.dto.SysUserDTO;
import com.hfocean.platform.request.PageRequest;
import com.hfocean.platform.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public int addUser(SysUserPo userPo) {
        return sysUserMapper.insert(userPo);
    }

    @Override
    public SysUserPo findByUserId(Long userId) {
        return sysUserMapper.findByUserId(userId);
    }

    @Override
    public SysUserDTO selectByUserId(Long userId) {
        return sysUserMapper.selectByUserId(userId);
    }

    @Override
    public PageResultDTO findPage(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<SysUserPo> sysUserPos = sysUserMapper.selectAll();
        return PageUtils.getPageResult(new PageInfo<>(sysUserPos));
    }
}
