package com.itheima.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BrandMapper extends BaseMapper<Brand> {
   List<Brand> selectAll();

   @Select("select * from tb_brand where id= #{id}")
   public Brand selectById(@Param("id") int id);
   //List<Brand> selectByCondition(@Param("status")int status,@Param("companyName")String companyName,@Param("brandName")String brandName);

  //List<Brand>selectByCondition(Brand brand);
   List<Brand>selectByCondition(Map map);
   List<Brand> selectBySingleCondition(Brand brand);
   void add(Brand brand);
   void update(Brand brand);
   void deleteById(int id);
   void deleteByIds(int[] ids);
}
