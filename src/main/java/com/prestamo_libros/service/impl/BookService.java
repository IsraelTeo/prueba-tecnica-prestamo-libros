package com.prestamo_libros.service.impl;

import com.prestamo_libros.dto.book.BookRequestDTO;
import com.prestamo_libros.dto.book.BookResponseDTO;
import com.prestamo_libros.mapper.BookMapper;
import com.prestamo_libros.model.Book;
import com.prestamo_libros.repository.IBookRepository;
import com.prestamo_libros.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

    private IBookRepository bookRepository;

    private BookMapper bookMapper;

    @Transactional
    @Override
    public BookResponseDTO save(BookRequestDTO request) {
        Book book = bookMapper.requestToBook(request);
        Book bookSaved = bookRepository.save(book);
        return bookMapper.bookToResponse(bookSaved);
    }
}
