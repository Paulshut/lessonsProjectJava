package org.sdsDelivery.entities;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String surname;
    private String email;
    private Long id;
    private String login;
    private String password;
    private RoleUser roleUser;
    private List<Parcel> parcels;
}