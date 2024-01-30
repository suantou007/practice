package com.itheima.mp.domain.dto;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.vo.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//从前端接收到的参数列举如下
@Data
@ApiModel(description = "分页结果")
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO<T> {
    @ApiModelProperty("总条数")
    private Long total;
    @ApiModelProperty("总页数")
    private Long pages;
    @ApiModelProperty("集合")
    private List<T> list;
    //自己转别人是toxxx，别人到自己是of
    public static <PO,VO> PageDTO<VO> of(Page<PO> p,Class<VO> clazz){
        PageDTO<VO> dto = new PageDTO<>();
        dto.setTotal(p.getTotal());
        dto.setPages(p.getPages());
        //保存数据
        List<PO> records=p.getRecords();
        if(CollUtil.isEmpty(records)){
            dto.setList(Collections.emptyList());
            return dto;
        }
        dto.setList(BeanUtil.copyToList(records,clazz));
        return dto;
    }
    public static <PO,VO> PageDTO<VO> of(Page<PO> p,  Function<PO,VO> convertor){
        PageDTO<VO> dto = new PageDTO<>();
        dto.setTotal(p.getTotal());
        dto.setPages(p.getPages());
        //保存数据
        List<PO> records=p.getRecords();
        if(CollUtil.isEmpty(records)){
            dto.setList(Collections.emptyList());
            return dto;
        }

        dto.setList(records.stream().map(convertor).collect(Collectors.toList()));
        return dto;
    }

}