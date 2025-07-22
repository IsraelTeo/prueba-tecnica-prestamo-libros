package com.prestamo_libros.mapper;

import com.prestamo_libros.dto.book.BookRequestDTO;
import com.prestamo_libros.dto.book.BookResponseDTO;
import com.prestamo_libros.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book requestToBook(BookRequestDTO request) {
        return Book.builder()
                .tittle(request.tittle())
                .author(request.author())
                .isbn(request.isbn())
                .available(request.available()) // Default value for new books
                .build();
    }

    public BookResponseDTO bookToResponse(Book book) {
        return BookResponseDTO.builder()
                .id(book.getId())
                .tittle(book.getTittle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .available(book.getAvailable())
                .build();
    }
}
