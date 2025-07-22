package com.prestamo_libros.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UserRequestDTO(

        @NotBlank(message = "Name must not be blank")
        @Size(max = 50, message = "Name must not exceed 50 characters")
        String name,


        @JsonProperty("last_name")
        @NotBlank(message = "Last name must not be blank")
        @Size(max = 80, message = "Last name must not exceed 80 characters")
        String lastName,

        @NotBlank(message = "DNI must not be blank")
        @Size(max = 12, message = "DNI must not exceed 12 characters")
        String dni
) { }
