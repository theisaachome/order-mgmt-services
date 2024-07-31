package com.isaachome.ecom.customer;


import lombok.*;
import org.springframework.validation.annotation.Validated;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Validated
public class Address {
    private String street;
    private String houseNumber;
    private String zipcode;
}

//db.createUser(
//{
//    user: "ecom-app",
//            pwd: "ecom-app@12345",
//        roles: [ { role: "role", db: "database" } ]
//}
//)