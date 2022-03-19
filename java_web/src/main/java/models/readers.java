package models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "readers")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class readers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "library_card_number")
    private long library_card_number;

    @Column(nullable = false, name = "surname")
    @NonNull
    private String surname;

    @Column(nullable = false, name = "name")
    @NonNull
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "address")
    private String address;

    @Column(unique = true, nullable = false, name = "reader_login")
    @NonNull
    private String reader_login;

    @Column(nullable = false, name = "reader_password")
    @NonNull
    private String reader_password;
}
