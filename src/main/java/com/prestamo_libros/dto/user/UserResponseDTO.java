package com.prestamo_libros.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record UserResponseDTO(
        Long id,
        @JsonProperty("full_name")
        String fullName,
        String dni
) {
}
