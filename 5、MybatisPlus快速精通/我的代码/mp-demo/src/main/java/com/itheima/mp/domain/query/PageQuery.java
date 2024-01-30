package com.itheima.mp.domain.query;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.mp.domain.po.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "分页查询实体")
public class PageQuery {
    @ApiModelProperty("页码")
    private Long pageNo=1L;
    @ApiModelProperty("页数")
    private Long pageSize=5L;
    @ApiModelProperty("排序字段")
    private String sortBy;
    @ApiModelProperty("是否升序")
    private Boolean isAsc = false;
//声明泛型+声明返回值
    public <T> Page<T> toMpPage(OrderItem ... items){
        Page<T> page = Page.of(pageNo,pageSize);
        //分页条件和量取完毕
        //非空处理
        if(StrUtil.isNotBlank(sortBy)){
            //排序条件
            page.addOrder(new OrderItem(sortBy,isAsc));
        }else if(items != null){
            //默认按照更新时间排序
            page.addOrder(items);
        }
        return page;
    }

    public <T> Page<T> toMpPage(String defaultSortBy,Boolean defaultAsc){
        return toMpPage(new OrderItem(defaultSortBy,defaultAsc));
    }
}