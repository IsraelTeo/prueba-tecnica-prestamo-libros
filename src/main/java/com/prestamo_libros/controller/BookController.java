package com.prestamo_libros.controller;


import com.prestamo_libros.dto.book.BookRequestDTO;
import com.prestamo_libros.dto.book.BookResponseDTO;
import com.prestamo_libros.service.impl.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponseDTO> save(@RequestBody @Valid BookRequestDTO request){
        BookResponseDTO response = bookService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
