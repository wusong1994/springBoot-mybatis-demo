package com.hfocean.platform.controller;

import com.hfocean.platform.core.exception.BaseBusinessException;
import com.hfocean.platform.core.util.ExportUtil;
import com.hfocean.platform.core.web.WebResponse;
import com.hfocean.platform.dto.SysUserDTO;
import com.hfocean.platform.request.PageRequest;
import com.hfocean.platform.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    SysUserService sysUserService;

    @RequestMapping("success")
    public WebResponse testSuccess() {
        SysUserDTO sysUserDTO = sysUserService.selectByUserId(4l);
        System.out.println(sysUserDTO);
        return new WebResponse(sysUserDTO);
    }

    @RequestMapping("fail")
    public WebResponse testFail() {
        throw new BaseBusinessException("业务异常");
    }


    /**
     * 分页
     * @param pageRequest
     * @return
     */
    @RequestMapping("page")
    public WebResponse getPage(PageRequest pageRequest) {
        return new WebResponse(sysUserService.findPage(pageRequest));
    }

    /**
     * 导出 mat
     * @param res
     * @throws Exception
     */
    @RequestMapping(value = "/downloadMat", method = RequestMethod.GET)
    public void downloadMat(HttpServletResponse res) throws Exception {
        ExportUtil.exportMat(res);
    }

    /**
     * 导出 txt
     * @param res
     * @throws Exception
     */
    @RequestMapping(value = "/downloadTXT", method = RequestMethod.GET)
    public void downloadTXT(HttpServletResponse res) throws Exception {
        ExportUtil.exportTxt(res);
    }

}
