package models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book_copies")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class book_copies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "copy_id")
    private long copy_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    @NonNull
    private books book_id;

    @Column(name = "copy_number")
    private long copy_number;
}
