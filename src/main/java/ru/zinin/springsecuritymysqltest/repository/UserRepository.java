package ru.zinin.springsecuritymysqltest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zinin.springsecuritymysqltest.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
}
