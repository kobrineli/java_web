package ru.msu.cmc.java_web.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "admin")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class admin {

    @Id
    @Column(nullable = false, name = "admin_id")
    private long admin_id;

    @Column(nullable = false, unique = true, name = "admin_login")
    @NonNull
    private String admin_login;

    @Column(name = "admin_password")
    private String admin_password;
}
