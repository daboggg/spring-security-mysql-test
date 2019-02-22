package ru.zinin.springsecuritymysqltest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.zinin.springsecuritymysqltest.domain.Role;
import ru.zinin.springsecuritymysqltest.domain.User;
import ru.zinin.springsecuritymysqltest.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void init() {



        /*User user = new User();
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("USER",user));
        user.setUsername("aaaa");
        user.setPassword("$2a$10$oKqSgpiKG4OGWv226CFTXOebXefNZ.Q5JdJBBz5.HbFevNRQpwdHq"); // zzzz
        user.setAuthorities(roles);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);

        userRepository.save(user);*/


        /*if (!userDao.findByUsername("user").isPresent()) {
            userDao.save(User.builder()
                    .username("user")
                    .password("password")
                    .authorities(ImmutableList.of(Role.USER))
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .build());
        }*/
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*List<Role> roles = new ArrayList<>();
        roles.add(new Role("USER"));
        User user = new User();
        user.setUsername("aaaa");
        user.setPassword("$2a$10$oKqSgpiKG4OGWv226CFTXOebXefNZ.Q5JdJBBz5.HbFevNRQpwdHq"); // zzzz
        user.setAuthorities(roles);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);*/

        return userRepository.findByUsername("aaaa");
    }
}
















