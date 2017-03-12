package dad.endlessElectronicMusic.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Public pages
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/contact.html").permitAll();
		http.authorizeRequests().antMatchers("/index.html").permitAll();
		http.authorizeRequests().antMatchers("/blog.html").permitAll();
		http.authorizeRequests().antMatchers("/songs-category.html").permitAll();
		http.authorizeRequests().antMatchers("/team.html").permitAll();
		http.authorizeRequests().antMatchers("/user-register.html").permitAll();
		http.authorizeRequests().antMatchers("/register").permitAll();
		
		// Private pages (all other pages)
		http.authorizeRequests().antMatchers("/blog-post.html").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/procesarComentario.html").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/songs-detail.html").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/user-account.html").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/vote.html").hasAnyRole("USER", "ADMIN");

		http.authorizeRequests().antMatchers("/admin/**").hasAnyRole("ADMIN");

		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("campoUser");
		http.formLogin().passwordParameter("campoPass");
		http.formLogin().defaultSuccessUrl("/index.html");
		http.formLogin().failureUrl("/login");

		// Logout
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// User
		auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");

		auth.inMemoryAuthentication().withUser("fran").password("1234").roles("USER", "ADMIN");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		web.ignoring().antMatchers("/upload/**"); // #3
	}

}