package btl.salecomputers.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userDataSource")
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// use jdbc authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/resources/css/**").permitAll().antMatchers("/resources/bootstrap/**")
				.permitAll().antMatchers("/resources/jquery/**").permitAll().antMatchers("/resources/fonts/**")
				.permitAll().antMatchers("/resources/img/**").permitAll().antMatchers("/").permitAll()

				.antMatchers("/maytinh/**").permitAll().antMatchers("/khachhang/list").hasRole("EMPLOYEE")
				.antMatchers("/search").permitAll()
				.antMatchers("/register/showRegistrationForm").permitAll()
				.antMatchers("/register/processRegistrationForm").permitAll().antMatchers("/khachhang/showFormForAdd")
				.permitAll().antMatchers("/khachhang/saveKhachHang").permitAll()
				
				.antMatchers("/maytinh/showGioHang")
				.hasRole("CUSTOMER")
				.antMatchers("/maytinh/showChiTietMayTinh").permitAll()
				.antMatchers("/giohang/showGioHang")
				.hasRole("CUSTOMER")
				
//				.antMatchers("/person/list/**").permitAll()
//				.antMatchers("/person/showFormForUpdate/**").hasAnyRole("MANAGER", "ADMIN")
//				.antMatchers("/person/showFormForAdd/**").hasAnyRole("MANAGER", "ADMIN")
//				.antMatchers("/person/delete/**").hasAnyRole("MANAGER", "ADMIN") EMLOYEE,CUSTOMER
				.anyRequest().authenticated().and().formLogin().loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser").defaultSuccessUrl("/", true).permitAll().and().logout()
				.permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");
	}

	@Bean
	public UserDetailsManager userDetailsManager() {

		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();

		jdbcUserDetailsManager.setDataSource(securityDataSource);

		return jdbcUserDetailsManager;
	}
	
}
