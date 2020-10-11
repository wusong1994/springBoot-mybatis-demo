package com.hfocean.platform;

import com.hfocean.platform.core.po.SysUserPo;
import com.hfocean.platform.dto.SysUserDTO;
import com.hfocean.platform.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestService {

    @Autowired
    SysUserService sysUserService;

    @Test
    public void testInsert(){
        SysUserPo sysUserPo = new SysUserPo();
        sysUserPo.setLoginName("ws");
        sysUserService.addUser(sysUserPo);
    }

    @Test
    public void testQuery(){
        SysUserPo sysUserPo = sysUserService.findByUserId(4l);
        System.out.println(sysUserPo);

        SysUserDTO sysUserDTO = sysUserService.selectByUserId(4l);
        System.out.println(sysUserDTO);
    }
}
