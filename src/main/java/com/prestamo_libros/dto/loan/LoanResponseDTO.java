package com.prestamo_libros.dto.loan;

import com.prestamo_libros.dto.book.BookResponseDTO;
import com.prestamo_libros.dto.user.UserResponseDTO;

import java.time.LocalDate;
import java.util.List;

public record LoanResponseDTO(
        Long id,
        UserResponseDTO user,
        List<BookResponseDTO> books,
        LocalDate loanDate,
        Boolean returned
) {
}
