package ru.zinin.springsecuritymysqltest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.zinin.springsecuritymysqltest.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .authorizeRequests()
                .antMatchers("/readme.txt", "/css/*").permitAll() //добавляем разрешения
                .anyRequest().authenticated() // все остальные запросы закрыты
                .and()
                .formLogin().permitAll() // добавляем форму логгирования (разрешена для всех)
                .and()
                .logout().permitAll(); //добавляем логаут (разрешен всем)
    }

    @Autowired
    UserService userService;

    @Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("aaa").password("$2a$10$kpH7GgA6Qua0hizYj1TiIOs6P9uPnWhwAqOOZOYIoAgH/f5yl.ZDe").roles("USER").and().passwordEncoder(bcryptPasswordEncoder());
        auth.userDetailsService(userService).passwordEncoder(bcryptPasswordEncoder());
    }
}






























