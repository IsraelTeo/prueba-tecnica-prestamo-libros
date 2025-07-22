package com.prestamo_libros.service.impl;

import com.prestamo_libros.dto.user.UserRequestDTO;
import com.prestamo_libros.dto.user.UserResponseDTO;
import com.prestamo_libros.repository.IUserRepository;
import com.prestamo_libros.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public Optional<UserResponseDTO> registerUser(UserRequestDTO request) {
        return Optional.empty();
    }
}
