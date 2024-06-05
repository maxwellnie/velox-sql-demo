package com.example.demo.po;

import com.maxwellnie.velox.sql.core.annotation.Column;
import com.maxwellnie.velox.sql.core.annotation.Entity;
import com.maxwellnie.velox.sql.core.annotation.PrimaryKey;
import com.maxwellnie.velox.sql.core.manager.KeyStrategyManager;
import com.maxwellnie.velox.sql.core.natives.type.convertor.impl.IntegerConvertor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Entity("tb_user")
public class User extends Base implements Serializable {
    @PrimaryKey(strategyKey = KeyStrategyManager.JDBC_AUTO, convertor = IntegerConvertor.class)
    private int userId;
    /**
     * 不排除这个数据库中没有的字段将报错。
     */
    @Column(isExclusion = true)
    private Object voidColumn;
    private String loginName;
    private String password;
    public User() {
    }
    public User(int userId, String loginName, String password) {
        this.userId = userId;
        this.loginName = loginName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", loginName=" + getLoginName() +
                ", password=" + getPassword() +
                '}';
    }
}

