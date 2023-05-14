package peaksoft.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/").hasAnyAuthority("ADMIN", "INSTRUCTOR", "STUDENT")
                .antMatchers("/companies/**").hasAuthority("ADMIN")
                .antMatchers("/courses/**").hasAnyAuthority("ADMIN", "INSTRUCTOR")
                .antMatchers("/groups/**").hasAnyAuthority("ADMIN", "INSTRUCTOR")
                .antMatchers("/teachers/**").hasAuthority("ADMIN")
                .antMatchers("/students/**").hasAnyAuthority("ADMIN", "INSTRUCTOR")
                .antMatchers("/users/**").hasAuthority("ADMIN")
                .antMatchers("/profile/**").hasAnyAuthority("ADMIN", "INSTRUCTOR", "STUDENT")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();
    }
}
