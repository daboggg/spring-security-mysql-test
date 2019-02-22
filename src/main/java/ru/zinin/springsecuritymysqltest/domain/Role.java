package ru.zinin.springsecuritymysqltest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role")
public class   Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String authority;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    public Role(String authority, User user) {
        this.authority = authority;
        this.user = user;
    }

    public Role(String authority) {
        this.authority = authority;
    }

    public Role() {
    }
}
