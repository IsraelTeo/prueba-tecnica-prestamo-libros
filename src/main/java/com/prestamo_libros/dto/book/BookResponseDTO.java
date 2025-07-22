package com.prestamo_libros.dto.book;

import lombok.Builder;

@Builder
public record BookResponseDTO(
        Long id,
        String tittle,
        String author,
        String isbn,
        boolean available
) {
}
