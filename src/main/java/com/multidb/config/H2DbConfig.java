package com.multidb.config;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "h2EntityManagerFactory", 
transactionManagerRef = "h2TransactionManager", basePackages = {"com.multidb.h2.repo" })
public class H2DbConfig {

	@Bean(name = "h2DataSource")
	@ConfigurationProperties(prefix = "db3.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "h2EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("h2DataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.multidb.h2.model").persistenceUnit("db3")
				.build();
	}

	@Bean(name = "h2TransactionManager")
	public PlatformTransactionManager h2TransactionManager(
			@Qualifier("h2EntityManagerFactory") EntityManagerFactory h2EntityManagerFactory) {
		return new JpaTransactionManager(h2EntityManagerFactory);
	}
}