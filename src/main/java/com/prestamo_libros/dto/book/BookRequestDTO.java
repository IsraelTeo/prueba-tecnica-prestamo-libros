package com.prestamo_libros.dto.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record BookRequestDTO(
        @NotBlank(message = "Title cannot be blank")
        @Size(max = 100, message = "Title must not exceed 100 characters")
        String tittle,

        @NotBlank(message = "Author cannot be blank")
        @Size(max = 100, message = "Author must not exceed 100 characters")
        String author,

        @NotBlank(message = "ISBN cannot be blank")
        @Size(max = 13, message = "ISBN must not exceed 13 characters")
        String isbn
) {
}
