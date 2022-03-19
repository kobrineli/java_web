package models;

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
