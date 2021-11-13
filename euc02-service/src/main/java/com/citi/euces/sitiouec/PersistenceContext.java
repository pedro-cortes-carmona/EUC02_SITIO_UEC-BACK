/**
 *
 */
package com.citi.euces.sitiouec;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lbermejo
 */
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan(basePackages = "com.citi.euces.sitiouec")
@PropertySource("classpath:services.properties")
public class PersistenceContext {

	private static final Logger LOGGER = LogManager.getLogger(PersistenceContext.class);

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()  {

		LOGGER.info("*** Configure: LocalContainerEntityManagerFactoryBean");
	    //JpaVendorAdapteradapter can be autowired as well if it's configured in application properties.
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(false);
	    vendorAdapter.setShowSql(true);
	    vendorAdapter.setDatabasePlatform("org.hibernate.dialect.Oracle12cDialect");

	    Properties jpaProperties = new Properties();
	    jpaProperties.put("hibernate.format_sql", "true");
	    jpaProperties.put("hibernate.hbm2ddl.auto", "none");

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    //Add package to scan for entities.
	    factory.setPackagesToScan("com.citi.euces.sitiouec");
	    factory.setDataSource(jndiDatasource());
	    factory.setJpaProperties(jpaProperties);

	    return factory;
	}

	@Bean(name = "datasource")
	public DataSource jndiDatasource(){
		DataSource ds = null;
		JndiTemplate jtmp = new JndiTemplate();
		try {
			ds = (DataSource) jtmp.lookup("jdbc/eucWeb");
		}catch (NamingException ne) {
			LOGGER.error(ne);
		}
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		LOGGER.info("*** Configure: JpaTransactionManager");
	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory);
	    return txManager;
	}

}
