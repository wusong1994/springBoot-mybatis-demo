package com.hfocean.platform.core.util;
import com.github.pagehelper.PageInfo;
import com.hfocean.platform.dto.PageResultDTO;
import com.hfocean.platform.request.PageRequest;

public class PageUtils {

    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest 
     * @param pageInfo
     * @return
     */
    public static PageResultDTO getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResultDTO pageResult = new PageResultDTO();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}