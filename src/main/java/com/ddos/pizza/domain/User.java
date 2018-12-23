package com.ddos.pizza.domain;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class User implements Serializable {

    private UUID id;
    private String name;
    private String password;
    private String phone;
    private String trueName;
}
