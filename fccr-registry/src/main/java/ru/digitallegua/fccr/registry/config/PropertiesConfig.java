package ru.digitallegua.fccr.registry.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class PropertiesConfig {

    @Value("${postgresql.dataSource.serverName}")
    private String postgresqlServerName;

    @Value("${postgresql.dataSource.portNumber}")
    private String postgresqlPortName;

    @Value("${postgresql.dataSource.databaseName}")
    private String postgresqlDatabaseName;

    @Value("${postgresql.dataSource.user}")
    private String postgresqlUsername;

    @Value("${postgresql.dataSource.password}")
    private String postgresqlPassword;

    @Value("${postgresql.dataSource.driver}")
    private String postgresqlDriver;

    @Value("${hibernate.jdbc.batch_size}")
    private String hibernateJdbcBatchSize;

    @Value("${hibernate.order_inserts}")
    private String hibernateOrderInserts;

    @Value("${hibernate.order_updates}")
    private String hibernateOrderUpdates;

    @Value("${hibernate.format_sql}")
    private String hibernateFormatSql;

    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;

    @Value("${hibernate.temp.use_jdbc_metadata_defaults}")
    private String hibernateTempUseJdbcMetadataDefaults;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;
}
