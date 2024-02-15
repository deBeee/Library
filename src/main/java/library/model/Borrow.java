package library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    private Book book;
    private LocalDate borrowDate;
    private boolean isReturned;
    @ManyToOne
    private User user;
    private String borrowerName;
    private String borrowerSurname;

    public Borrow(Book book, LocalDate borrowDate, boolean isReturned, User user) {
        this.book = book;
        this.borrowDate = borrowDate;
        this.isReturned = isReturned;
        this.user = user;
    }
}
