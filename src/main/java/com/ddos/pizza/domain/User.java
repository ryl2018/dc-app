package com.ddos.pizza.domain;

import lombok.*;

import java.util.UUID;
@Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
public class User {
    private UUID id;
    private String name;
    private String password;
    private String phone;
    private String trueName;
}
