package ru.digitallegua.fccr.registry.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@RequiredArgsConstructor
@EnableJpaRepositories(basePackages = {"ru.digitallegua.fccr.registry.db.repository"})
@EnableTransactionManagement
public class PersistenceConfig {

    private final PropertiesConfig propertiesConfig;

    @Bean
    public HikariDataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(propertiesConfig.getPostgresqlDriver());
        config.setJdbcUrl(String.format("jdbc:postgresql://%s:%s/%s",
                propertiesConfig.getPostgresqlServerName(),
                propertiesConfig.getPostgresqlPortName(),
                propertiesConfig.getPostgresqlDatabaseName()));
        config.setUsername(propertiesConfig.getPostgresqlUsername());
        config.setPassword(propertiesConfig.getPostgresqlPassword());
        return new HikariDataSource(config);
    }

    @Bean
    public Properties hibernateSpecificProperties() {
        Properties proprs = new Properties();
        proprs.setProperty("hibernate.jdbc.batch_size", propertiesConfig.getHibernateJdbcBatchSize());
        proprs.setProperty("hibernate.order_inserts", propertiesConfig.getHibernateOrderInserts());
        proprs.setProperty("hibernate.order_updates", propertiesConfig.getHibernateOrderUpdates());
        proprs.setProperty("hibernate.format_sql", propertiesConfig.getHibernateFormatSql());
        proprs.setProperty("hibernate.show_sql",  propertiesConfig.getHibernateShowSql());
        proprs.setProperty("hibernate.temp.use_jdbc_metadata_defaults", propertiesConfig.getHibernateTempUseJdbcMetadataDefaults());
        proprs.setProperty("hibernate.dialect", propertiesConfig.getHibernateDialect());
        return proprs;

    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.POSTGRESQL);
        vendorAdapter.setGenerateDdl(false);
        vendorAdapter.setShowSql(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("ru.digitallegua.fccr.registry.db.entity");
        factory.setDataSource(dataSource());
        factory.setJpaProperties(hibernateSpecificProperties());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }
}
