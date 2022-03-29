package ru.msu.cmc.java_web.models;

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
    @Column(nullable = false, name = "copy_id")
    private long copy_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    @NonNull
    private books book_id;

    @Column(name = "copy_number")
    private long copy_number;
}
