package btl.salecomputers.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = "btl.salecomputers")
@PropertySource("classpath:persistence-mssql.properties")
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;


	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	//User
	@Bean("userDataSource")
	public DataSource userDataSource() {
		ComboPooledDataSource userDataSource = new ComboPooledDataSource();
		try {
			userDataSource.setDriverClass(env.getProperty("jdbc.driver2"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		userDataSource.setJdbcUrl(env.getProperty("jdbc.url2"));
		userDataSource.setUser(env.getProperty("jdbc.user2"));
		userDataSource.setPassword(env.getProperty("jdbc.password2"));
		userDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		userDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		userDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		userDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		return userDataSource;
	}
	
	@Bean("userSessionFactory")
	public LocalSessionFactoryBean userSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(userDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hiberante.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}
	
	@Bean("userTransactionManager")
	@Autowired
	public HibernateTransactionManager userTransactionManager(@Qualifier("userSessionFactory") SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
	
	
	
	
	//web
	
	@Primary
	@Bean("webDataSource")
	public DataSource webDataSource() {
		ComboPooledDataSource webDataSource = new ComboPooledDataSource();
		try {
			webDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		webDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		webDataSource.setUser(env.getProperty("jdbc.user"));
		webDataSource.setPassword(env.getProperty("jdbc.password"));
		webDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		webDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		webDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		webDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		return webDataSource;
	}
	
	@Bean("webSessionFactory")
	public LocalSessionFactoryBean webSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(webDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hiberante.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}
	
	@Bean("webTransactionManager")
	@Autowired
	public HibernateTransactionManager webTransactionManager(@Qualifier("webSessionFactory") SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
	
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() {
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		multipartResolver.setMaxInMemorySize(1048576);
		multipartResolver.setMaxUploadSize(20971520);
		return multipartResolver;
	}

	
	
	
	
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		int intPropVal = Integer.parseInt(propVal);
		return intPropVal;
	}
	
	

	private Properties getHibernateProperties() {
		// set hibernate properties
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return props;
	}
	

	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}
