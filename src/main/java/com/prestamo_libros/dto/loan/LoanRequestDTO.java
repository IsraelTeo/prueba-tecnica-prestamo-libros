package com.prestamo_libros.dto.loan;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record LoanRequestDTO(

        @JsonProperty("user_id")
        @NotNull(message = "User ID must be provided")
        @Min(value = 1, message = "User ID must be a positive number")
        Long userId,

        @JsonProperty("books_ids")
        @NotEmpty(message = "At least one book ID must be provided")
        List<@NotNull(message = "Book ID cannot be null") @Min(value = 1, message = "Book ID must be a positive number") Long> bookIds
) {
}
