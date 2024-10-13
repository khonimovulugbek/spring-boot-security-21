package com.spring.model;


import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<String> authorities;
    @Column(name = "is_blocked")
    private boolean isBlocked;
    @Column(name = "is_enable")
    private boolean isEnable = true;
    @Column(name = "account_expired_date")
    private LocalDateTime accountExpiredDate;
    @Column(name = "credentials_expired_date")
    private LocalDateTime credentialsExpiredDate;
}
