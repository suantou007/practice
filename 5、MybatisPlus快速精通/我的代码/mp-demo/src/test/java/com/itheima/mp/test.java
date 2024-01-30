package com.itheima.mp;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.mp.domain.po.Address;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.service.IAddressService;
import com.itheima.mp.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


class test {
    static
    @SpringBootTest
    class IAddressserviceTest {
        @Autowired
        private IAddressService addressService;

        @Test
        void testLogicDelete() {
            addressService.removeById(60L);
            Address address =addressService.getById(60L);
            System.out.println("address ="+address);
        }
        @Test
        void testDeleteByLogic() {
            // 删除方法与以前没有区别
            addressService.removeById(59L);
        }
        @Test
        void testQuery() {
            List<Address> list = addressService.list();
            list.forEach(System.out::println);
        }
    }
    @SpringBootTest
    static
    class IserviceTest {
        @Autowired
        private IUserService userService;

        @Test
        void testService() {

            List<User> list = userService.list();
            list.forEach(System.out::println);
        }
        @Test
        void testPage() {
            int pageNo=1,pageSize=2;
            Page<User> page = Page.of(pageNo,pageSize);
            page.addOrder(new OrderItem("balance",true));
            page.addOrder(new OrderItem("id",true));
            Page<User> p =userService.page(page);
            long total= p.getTotal();
            System.out.println("total="+total);
            long pages = p.getPages();
            System.out.println("pages="+pages);
            List<User> users=p.getRecords();
            users.forEach(System.out::println);
        }
    }
}
