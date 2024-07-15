package com.example.demo.service;


import com.example.demo.po.User;
import com.maxwellnie.velox.sql.core.natives.dao.BaseDao;
import com.maxwellnie.velox.sql.core.natives.dao.Page;
import com.maxwellnie.velox.sql.core.natives.dao.SqlDecorator;
import com.maxwellnie.velox.sql.core.utils.jdbc.CurrentThreadUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author Maxwell Nie
 */
@Service
public class UserService {
    @Resource
    private BaseDao<User> userDao;
    @Transactional
    public List<User> selectAll() {
        return userDao.select(null);
    }
    public User getUser(SqlDecorator<User> sqlDecorator){
        return userDao.select(sqlDecorator).stream().findFirst().orElse(null);
    }
    @Transactional
    public void insert(User user) {
        userDao.insert(user);
    }

    public int update(User user, SqlDecorator<User> sqlDecorator) {
        return userDao.update(user, sqlDecorator);
    }
    public int delete(SqlDecorator<User> sqlDecorator) {
        return userDao.delete(sqlDecorator);
    }
    public Page<User> selectPage(Page<User> page, SqlDecorator<User> sqlDecorator){
        return userDao.selectPage(page, sqlDecorator);
    }
    @Transactional
    public List<User> move(User user0, User user1, SqlDecorator<User> sqlDecorator) {
        CurrentThreadUtils.setDataSourceName("second");
        int[] count = userDao.batchInsert(Arrays.asList(user1, user1, user1, user1, user1, user1, user1, user1));
        System.out.println(userDao.select(null).size());
        if(count.length == 0)
            throw new RuntimeException();
        CurrentThreadUtils.clearDataSourceName();
        int count1 = userDao.update(user1, sqlDecorator);
        if (count1 <= 0)
            throw new RuntimeException();
        return userDao.select(null);
    }
}
