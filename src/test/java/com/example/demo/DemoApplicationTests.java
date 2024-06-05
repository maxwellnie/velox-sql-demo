package com.example.demo;

import com.example.demo.po.User;
import com.maxwellnie.velox.sql.core.natives.dao.BaseDao;
import com.maxwellnie.velox.sql.core.natives.dao.SqlDecorator;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {
    @Resource
    BaseDao<User> userBaseDao;

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
        user.setLoginName("maxwell");
        user.setPassword("123456");
        System.err.println("添加结果:" + userBaseDao.insert(user));
        SqlDecorator<User> sqlDecorator = new SqlDecorator<User>().where().eq("user_id", user.getUserId()).build();
        System.err.println("该条目:" + userBaseDao.select(sqlDecorator));
        /**
         * 测试更新
         */
        user.setLoginName("????sdjks");
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
}
