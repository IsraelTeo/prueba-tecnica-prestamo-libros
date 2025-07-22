package com.prestamo_libros.service;

import com.prestamo_libros.dto.book.BookRequestDTO;
import com.prestamo_libros.dto.book.BookResponseDTO;

public interface IBookService {

    BookResponseDTO save(BookRequestDTO request);
}
