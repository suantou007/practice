package com.itheima.mp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.itheima.mp.domain.dto.PageDTO;
import com.itheima.mp.domain.po.Address;
import com.itheima.mp.domain.po.User;

import com.itheima.mp.domain.query.PageQuery;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.AddressVO;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.enums.UserStatus;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements IUserService {
    @Override
    public void deductBalance(Long id, Integer money) {
        User user = getById(id);
        //反向校验！
        if(user == null||user.getStatus()== UserStatus.FROZEN){
            throw new RuntimeException("用户状态异常");
        }
        if(user.getBalance()<money){
            throw new RuntimeException("用户余额不足");
        }
        int remainBalance = user.getBalance() - money;
        lambdaUpdate()
                .set(User::getBalance, remainBalance) // 更新余额
                .set(remainBalance == 0, User::getStatus, UserStatus.FROZEN) // 动态判断，是否更新status
                .eq(User::getId, id)
                .eq(User::getBalance, user.getBalance()) // 乐观锁
                .update();
    }

    @Override
    public List<User> queryUsers(String name,Integer status,Integer minBalance,Integer maxBalance){

        // 2.查询用户
        return  lambdaQuery()
                .like(name != null, User::getUsername, name)
                .eq(status != null, User::getStatus, status)
                .ge(minBalance != null, User::getBalance, minBalance)
                .le(maxBalance != null, User::getBalance, maxBalance)
                .list();
    }
     @Override
     public List<UserVO> queryUserAndAddressById(List<Long> ids) {
        // 1.查询用户
        List<User> users = listByIds(ids);
        if(CollUtil.isEmpty(users)){
            return Collections.emptyList();
        }
        List<Long> userIds = users.stream().map(User::getId).collect(Collectors.toList());
        // 2.处理vo
        List<Address> addresses=Db.lambdaQuery(Address.class).in(Address::getUserId,userIds).list();

        List<AddressVO> addressVOList=BeanUtil.copyToList(addresses,AddressVO.class);
        //转化到这里结束，下面分组匹配对象
         // 依据getUserId的反射值针对addressVO进行分组
         Map<Long,List<AddressVO>> addressMap = new HashMap<>(0);
         if (CollUtil.isNotEmpty(addressVOList)){
             addressMap=addressVOList.stream().collect(Collectors.groupingBy(AddressVO::getUserId));
         }

        List<UserVO> list = new ArrayList<>(users.size());
        for(User user:users) {
            UserVO vo = BeanUtil.copyProperties(user, UserVO.class);
            list.add(vo);

            vo.setAddress(addressMap.get(user.getId()));
        }
        return list;
    }

    @Override
    public UserVO queryUserAndAddressById(Long userId) {
        // 1.查询用户
        User user = getById(userId);
        if (user == null || user.getStatus()==UserStatus.FROZEN) {
            throw new RuntimeException("用户异常");
        }
        // 2.查询收货地址
        List<Address> addresses = Db.lambdaQuery(Address.class)
                .eq(Address::getUserId, userId)
                .list();
        // 3.处理vo
        UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
        if(CollUtil.isNotEmpty(addresses)){
            userVO.setAddress(BeanUtil.copyToList(addresses, AddressVO.class));
        }
        return userVO;
    }

    @Override
    public PageDTO<UserVO> queryUsersPage(PageQuery query) {
        // 1.构建条件
        // 1.1.分页条件
        Page<User> page = Page.of(query.getPageNo(), query.getPageSize());
        // 1.2.排序条件
        if (query.getSortBy() != null) {
            page.addOrder(new OrderItem(query.getSortBy(), query.getIsAsc()));
        }else{
            // 默认按照更新时间排序
            page.addOrder(new OrderItem("update_time", false));
        }
        // 2.查询
        page(page);
        // 3.数据非空校验
        List<User> records = page.getRecords();
        if (records == null || records.size() <= 0) {
            // 无数据，返回空结果
            return new PageDTO<>(page.getTotal(), page.getPages(), Collections.emptyList());
        }
        // 4.有数据，转换
        List<UserVO> list = BeanUtil.copyToList(records, UserVO.class);
        // 5.封装返回
        return new PageDTO<UserVO>(page.getTotal(), page.getPages(), list);
    }
    @Override
    public PageDTO<UserVO> queryUsersPage(UserQuery query){
        String name = query.getName();
        Integer status= query.getStatus();
        Page<User> page = query.toMpPage("update_time",false);

        //分页查询
        Page<User> p=lambdaQuery()
                .like(name!=null,User::getUsername,name)
                .eq(status!=null,User::getStatus,status)
                .page(page);
        //封装VO结果
        //模板就位
       // return PageDTO.of(p,UserVO.class);
       // return PageDTO.of(p,user -> BeanUtil.copyProperties(user,UserVO.class));
        return PageDTO.of(p,user ->{
            //基础属性
            UserVO vo = BeanUtil.copyProperties(user,UserVO.class);
            //特殊事件
            vo.setUsername(vo.getUsername().substring(0,vo.getUsername().length()-2)+"**");
            return vo;
        });
    }
}