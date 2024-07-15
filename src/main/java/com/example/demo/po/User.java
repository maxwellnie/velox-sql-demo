package com.example.demo.po;

import com.maxwellnie.velox.sql.core.annotation.*;
import com.maxwellnie.velox.sql.core.natives.enums.JoinType;
import com.maxwellnie.velox.sql.core.natives.jdbc.table.primary.KeyStrategyManager;
import com.maxwellnie.velox.sql.core.natives.type.convertor.impl.IntegerConvertor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Entity("tb_user")
@JoinTable(slaveTableName = "tb_role", masterTableField = "roleId", slaveTableJoinColumn = "role_id", joinType = JoinType.LEFT)
public class User implements Serializable {
    @PrimaryKey(strategyKey = KeyStrategyManager.JDBC_AUTO, convertor = IntegerConvertor.class)
    private int userId;
    private String loginname;
    private String password;
    private int roleId;
    @SlaveField(slaveTableName = "tb_role")//标记为从表字段
    private String roleName;
}

