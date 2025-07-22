package com.prestamo_libros.dto.loan;

import com.prestamo_libros.dto.book.BookResponseDTO;
import com.prestamo_libros.dto.user.UserResponseDTO;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record LoanResponseDTO(
        Long id,
        UserResponseDTO user,
        List<BookResponseDTO> books,
        LocalDate loanDate,
        Boolean returned
) {
}
