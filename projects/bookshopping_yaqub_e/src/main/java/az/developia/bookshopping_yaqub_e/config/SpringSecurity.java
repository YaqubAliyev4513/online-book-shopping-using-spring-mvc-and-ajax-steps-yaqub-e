package az.developia.bookshopping_yaqub_e.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter{

	

	@Autowired
    DataSource dataSource;

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/").permitAll()
                .antMatchers(HttpMethod.GET,"/home").permitAll()
                .antMatchers(HttpMethod.GET,"/createUserShowForm").permitAll()
                .antMatchers(HttpMethod.POST,"/createUserProcess").permitAll()
                .antMatchers(HttpMethod.GET,"/customer").permitAll()
                .antMatchers(HttpMethod.GET,"/orders-rest").permitAll()
                .antMatchers(HttpMethod.POST,"/orders-rest").permitAll()
                .antMatchers(HttpMethod.GET,"/customer-rest/find-partial").permitAll()
                .antMatchers(HttpMethod.GET,"/customer/confirmation-form").permitAll()
                .antMatchers(HttpMethod.GET,"/basket").permitAll()
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .anyRequest().authenticated().and().formLogin().loginPage("/showLoginPage")
             
                .loginProcessingUrl("/authenticateTheUser").permitAll()
                .and()
                .logout()
                .permitAll();
                
	}  
	
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
            
    }
}
