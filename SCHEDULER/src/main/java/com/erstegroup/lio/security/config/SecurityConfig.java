package com.erstegroup.lio.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.erstegroup.lio.constants.ControllerUrlConstants;
import com.erstegroup.lio.constants.DatabaseConstants;
import com.erstegroup.lio.utils.SchedulerUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		String userSql = SchedulerUtil.join("select ul_user_name,ul_password,ul_enabled from ", DatabaseConstants.SCHEDULER_DB_SCHEMA , "." ,
				DatabaseConstants.USER_LOGIN , " where ul_user_name = ?");
		String roleSql = SchedulerUtil.join("select ul_user_name,ul_role from ", DatabaseConstants.SCHEDULER_DB_SCHEMA , "." ,
				DatabaseConstants.USER_LOGIN , " where ul_user_name = ?");
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(userSql)
		.authoritiesByUsernameQuery(roleSql);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(ControllerUrlConstants.INDEX_URL).access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
		.and()
		.formLogin().loginPage(ControllerUrlConstants.LOGIN_URL)
		.defaultSuccessUrl(ControllerUrlConstants.INDEX_URL)
		.failureUrl(SchedulerUtil.join(ControllerUrlConstants.LOGIN_URL,"?error"))
		.usernameParameter("j_username").passwordParameter("j_password")
		.and()
		.logout().logoutSuccessUrl(SchedulerUtil.join(ControllerUrlConstants.LOGIN_URL,"?logout"))
		.and()
		.exceptionHandling().accessDeniedPage(ControllerUrlConstants.ERROR_URL)
		.and()
		.csrf();
	}

}
