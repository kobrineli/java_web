package models;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "book_id")
    private long book_id;

    @Column(nullable = false, name = "book_name")
    @NonNull
    private String book_name;

    @Column(name = "authors")
    private String[] authors;

    @Column(nullable = false, name = "publisher")
    @NonNull
    private String publisher;

    @Column(name = "publish_year")
    private long publish_year;

    @Column(name = "isbn")
    private long isbn;

    @Column(name = "total_amount")
    private long total_amount;

    @Column(name = "current_count")
    private long current_count;
}
