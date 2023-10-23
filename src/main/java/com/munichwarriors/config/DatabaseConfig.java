package com.munichwarriors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver"); // Replace with your database driver
        dataSource.setUrl("jdbc:h2:mem:munichwarriorsdb"); // Replace with your database URL
        dataSource.setUsername("nitesh"); // Replace with your database username
        dataSource.setPassword("nitesh"); // Replace with your database password
        return dataSource;
    }
}

