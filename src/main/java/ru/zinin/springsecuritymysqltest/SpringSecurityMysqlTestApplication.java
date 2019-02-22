package ru.zinin.springsecuritymysqltest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.zinin.springsecuritymysqltest.domain.User;
import ru.zinin.springsecuritymysqltest.repository.UserRepository;

@SpringBootApplication
@Controller
public class SpringSecurityMysqlTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityMysqlTestApplication.class, args);
    }

    @GetMapping(path = "/hello")
    @ResponseBody
    public String hello() {
        return "HUILO";
    }

    @Autowired
    UserRepository userRepository;

    @GetMapping(name = "/user")
    @ResponseBody
    public User getUser() {
        return userRepository.findByUsername("aaaa");
    }

    /*@Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }*/



    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("aaa").password("$2a$10$kpH7GgA6Qua0hizYj1TiIOs6P9uPnWhwAqOOZOYIoAgH/f5yl.ZDe").roles("USER").and().passwordEncoder(bcryptPasswordEncoder());
    }*/
}

