package com.example.demo;

import com.example.demo.po.User;
import com.example.demo.service.UserService;
import com.maxwellnie.velox.sql.core.natives.dao.BaseDao;
import com.maxwellnie.velox.sql.core.natives.dao.SqlDecorator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionManager;

import javax.annotation.Resource;

@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {
    @Resource
    BaseDao<User> userBaseDao;
    @Resource
    UserService userService;
    @Resource
    TransactionManager transactionManager;
    @Test
    void test1(){
            System.out.println("查询结果:" + userService.selectAll().size());
            User user = new User();
            user.setLoginname("maxwell");
            user.setPassword("123456");
            User user1 = new User();
            user1.setLoginname("hjhjgh");
            user1.setPassword("sffsfs");
            userService.move(user, user1, new SqlDecorator<User>()
                    .where()
                    .eq("user_id", 29)
                    .build());
    }
    @org.junit.jupiter.api.Test
    void test() {
        /**
         * 测试查询
         */
        System.err.println("查询结果:" + userBaseDao.select(null).size());
        /**
         * 测试分页查询
         */
        System.err.println("分页结果:" + userBaseDao.selectPage(null, null).getResult());
        /**
         * 测试插入
         */
        User user = new User();
        user.setLoginname("maxwell");
        user.setPassword("123456");
        System.err.println("添加结果:" + userBaseDao.insert(user));
        SqlDecorator<User> sqlDecorator = new SqlDecorator<User>().where().eq("user_id", user.getUserId()).build();
        System.err.println("该条目:" + userBaseDao.select(sqlDecorator));
        /**
         * 测试更新
         */
        user.setLoginname("????sdjks");
        System.err.println("更新结果:" + userBaseDao.update(user, sqlDecorator));
        System.err.println("被更新条目:" + userBaseDao.select(sqlDecorator));
        /**
         * 测试删除
         */
        System.err.println("删除结果:" + userBaseDao.delete(sqlDecorator));
        System.err.println("该条目:" + userBaseDao.select(sqlDecorator));
        /**
         * 测试查询条目
         */
        System.err.println("总数据量:" + userBaseDao.count(null));

    }

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("123");
        ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
        System.err.println(threadLocal1.get());
    }
}
