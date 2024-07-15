package com.example.demo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.maxwellnie.velox.sql.core.natives.jdbc.datasource.DataSourceManager;
import com.maxwellnie.velox.sql.core.natives.jdbc.dialect.MySqlDialect;
import com.maxwellnie.velox.sql.core.natives.jdbc.session.JdbcSessionFactory;
import com.maxwellnie.velox.sql.core.natives.task.DefaultTaskQueue;
import com.maxwellnie.velox.sql.spring.config.bean.VeloxAdvancedConfiguration;
import com.maxwellnie.velox.sql.spring.tx.JdbcSessionTransactionManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author Maxwell Nie
 */
@Configuration
public class VeloxSqlConfig extends VeloxAdvancedConfiguration {
    public VeloxSqlConfig() {

    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource secondDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
    @Bean
    public PlatformTransactionManager transactionManager(JdbcSessionFactory jdbcSessionFactory) {
        return new JdbcSessionTransactionManager(jdbcSessionFactory);
    }
    @Override
    protected void manageDataSource() {
        DataSourceManager.register("first",dataSource());
        DataSourceManager.register("second",secondDataSource());
    }

    @Override
    protected void configurationChanged(com.maxwellnie.velox.sql.core.config.Configuration configuration) {
        configuration.setDialect(new MySqlDialect());
        configuration.setTaskQueue(new DefaultTaskQueue());
    }
}
