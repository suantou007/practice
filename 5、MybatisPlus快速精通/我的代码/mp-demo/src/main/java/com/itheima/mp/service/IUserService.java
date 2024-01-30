package com.itheima.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.mp.domain.dto.PageDTO;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.domain.query.PageQuery;

import java.util.List;

public interface IUserService extends IService<User> {
    // 拓展自定义方法
    void deductBalance(Long id, Integer money);

    List<User> queryUsers(String name, Integer status, Integer minBalance, Integer maxBalance);

    UserVO queryUserAndAddressById(Long userId);
    List<UserVO> queryUserAndAddressById(List<Long> ids);

    PageDTO<UserVO> queryUsersPage(PageQuery query);
    PageDTO<UserVO> queryUsersPage(UserQuery query);
}