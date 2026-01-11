//package com.dracarys.springjpa.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class AppConfig {
//
//    @Bean
//    public DataSource getDataSource() {
//        HikariDataSource ds = new HikariDataSource();
//        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        ds.setJdbcUrl("jdbc:mysql://localhost:3306/springboot");
//        ds.setUsername("root");
//        ds.setPassword("3495");
//        return ds;
//    }
//
//    @Bean
//    public JpaVendorAdapter getJpaVendorAdapter() {
//        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//        jpaVendorAdapter.setGenerateDdl(true);
//        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
//        return jpaVendorAdapter;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setDataSource(dataSource);
//        emf.setJpaVendorAdapter(jpaVendorAdapter);
//        emf.setPackagesToScan("com.dracarys.springjpa");
//        emf.setPersistenceUnitName("springjpa");
//        return emf;
//    }
//}
