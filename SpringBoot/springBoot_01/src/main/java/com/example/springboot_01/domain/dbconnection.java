package com.example.springboot_01.domain;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
@ConfigurationProperties(prefix="dbconnection")
public class dbconnection {
    private String driver;
    private String url;
    private String username;
    private String password;
}
