package peaksoft.configs;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class JpaConfig {
    private final Environment environment;

    @Autowired
    public JpaConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean local = new LocalContainerEntityManagerFactoryBean();
        local.setJpaVendorAdapter(getJpaVendorAdapter());
        local.setDataSource(getDataSource());
        local.setPersistenceUnitName("myPersistenceUnitName");
        local.setPackagesToScan("peaksoft.entities");
        local.setJpaProperties(getProperties());
        return local;
    }

    @Bean
    public JpaVendorAdapter getJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }
    @Bean
    public DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("db.driverClassName"));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setUsername(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));
        return dataSource;
    }
    @Bean
    public PlatformTransactionManager transactionManager(){
        return new JpaTransactionManager
                (Objects.requireNonNull(getEntityManagerFactoryBean().getObject()));
    }

    public Properties getProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect",environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql",environment.getProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto",environment.getProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }


}
