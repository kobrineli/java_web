package ru.msu.cmc.java_web.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reader_story")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class reader_story {

    @Id
    @Column(nullable = false, name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reader_id")
    @NonNull
    private readers reader_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "copy_id")
    @NonNull
    private book_copies copy_id;

    @Column(name = "issue_date")
    private LocalDate issue_date;

    @Column(name = "return_date")
    private LocalDate return_date;
}
