package com.mall.common.api;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

@Data
public class CommonPage<T> {
    //第几页
    private Integer pageNum;
    //一页显示多少条记录
    private Integer pageSize;
    //有多少页
    private Integer totalPage;
    //总记录数字
    private Long total;

    private List<T> list;

    public static <T> CommonPage<T> resultPage(List<T> list) {
        CommonPage<T> result = new CommonPage<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }
}
