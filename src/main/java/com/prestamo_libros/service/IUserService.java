package com.prestamo_libros.service;

import com.prestamo_libros.dto.user.UserRequestDTO;
import com.prestamo_libros.dto.user.UserResponseDTO;

import java.util.Optional;

public interface IUserService {
  Optional<UserResponseDTO> registerUser(UserRequestDTO request);
}
