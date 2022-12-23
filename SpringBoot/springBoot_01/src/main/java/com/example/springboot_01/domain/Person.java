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
@ConfigurationProperties(prefix="person")
public class Person {
    private String name;
    private Integer age;
    private Double salary;
}
