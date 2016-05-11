package edu.university.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.activation.DataSource;
import javax.persistence.EntityManagerFactory;

/**
 * Created by gleb on 11.05.16.
 */
@Configuration
@EnableTransactionManagement
public class TransactionManagementConfig {
    @Autowired
    EntityManagerFactory emf;
    //@Autowired
    //private DataSource dataSource;


    @Bean
    public JpaTransactionManager transactionManager() {
        final JpaTransactionManager tm = new JpaTransactionManager();


        tm.setEntityManagerFactory(emf);
        //tm.setDataSource(dataSource);
        return tm;
    }

}
