package edu.university.presentation;
/**
 * Created by gleb on 15.04.16.
 */

import org.springframework.context.annotation.*;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@ComponentScan("edu.university")
public class AppConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        //sudo docker run -d --net="host" -it market-mysql
        Map<String, Object> jpaProp = em.getJpaPropertyMap();
        jpaProp.put("eclipselink.weaving", "false");
        em.setJpaPropertyMap(jpaProp);
        em.setDataSource(dataSource);
        em.setPackagesToScan("edu.university.domain");

        JpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/supermarket");
        dataSource.setUsername("root");
        dataSource.setPassword("firebird1970");

        return  dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return  transactionManager;
    }

   /* @Bean
    public PersistenceExceptionTranslationPostProcessor exeptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }*/
}
