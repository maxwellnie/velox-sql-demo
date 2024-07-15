package com.example.demo.po;

import com.maxwellnie.velox.sql.core.annotation.Entity;
import com.maxwellnie.velox.sql.core.annotation.PrimaryKey;
import com.maxwellnie.velox.sql.core.natives.jdbc.table.primary.KeyStrategyManager;
import com.maxwellnie.velox.sql.core.natives.type.convertor.impl.IntegerConvertor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Maxwell Nie
 */
@Getter
@Setter
@Entity("tb_role")
public class Role {
    @PrimaryKey(strategyKey = KeyStrategyManager.JDBC_AUTO, convertor = IntegerConvertor.class)
    private int roleId;
    private String roleName;
}
