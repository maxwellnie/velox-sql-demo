package com.example.demo.po;

import com.maxwellnie.velox.sql.core.annotation.Entity;
import com.maxwellnie.velox.sql.core.annotation.PrimaryKey;
import com.maxwellnie.velox.sql.core.natives.jdbc.table.primary.KeyStrategyManager;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Bound {
    @PrimaryKey(strategyKey = KeyStrategyManager.JDBC_AUTO)
    private int boundId;
    private String boundName;
    private String detail;
    private int count;

    @Override
    public String toString() {
        return "Bound{" +
                "boundId=" + boundId +
                ", boundName='" + boundName + '\'' +
                ", detail='" + detail + '\'' +
                ", count=" + count +
                '}';
    }
}
