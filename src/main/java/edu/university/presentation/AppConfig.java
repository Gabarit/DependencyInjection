package edu.university.presentation;
/**
 * Created by gleb on 15.04.16.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@ComponentScan("edu.university")
public class AppConfig {//implements TransactionManagementConfigurer{

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        final LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        Map<String, Object> jpaProp = emf.getJpaPropertyMap();
        jpaProp.put("eclipselink.weaving", "false");

        emf.setJpaPropertyMap(jpaProp);
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("edu.university.domain");

        JpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
        emf.setJpaVendorAdapter(vendorAdapter);

        return emf;
    }

    @Bean
    public DataSource dataSource() {

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/supermarket");
        dataSource.setUsername("root");
        dataSource.setPassword("firebird1970");

        return  dataSource;
    }

    /*@Autowired
    EntityManagerFactory emf;

    @Bean
    public PlatformTransactionManager transactionManager() {
        final JpaTransactionManager tm = new JpaTransactionManager();


        tm.setEntityManagerFactory(emf);
        //tm.setDataSource(dataSource());
        return tm;
    }

    /*public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManager();
    }

   /* @Bean
    public PersistenceExceptionTranslationPostProcessor exeptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }*/
}
