package com.prestamo_libros.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"books"})
@ToString(exclude = {"books"})
@Builder
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            targetEntity = UserEntity.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE,
            optional = false
    )
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToMany(
            targetEntity = Book.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE
    )
    @JoinTable(
            name = "loan_books",
            joinColumns = @JoinColumn(name = "loan_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

    private boolean returned;

    private LocalDate loanDate;

    private LocalDate returnDate;
}
