package com.prestamo_libros.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, updatable = true)
    private String tittle;

    @Column(nullable = false, length = 100, updatable = true)
    private String author;

    @Column(nullable = false, unique = true, length = 20, updatable = false)
    private String isbn; // International Standard Book Number

    private boolean available;
}
