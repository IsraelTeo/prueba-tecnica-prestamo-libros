package com.prestamo_libros.service.impl;

import com.prestamo_libros.dto.user.UserRequestDTO;
import com.prestamo_libros.dto.user.UserResponseDTO;
import com.prestamo_libros.mapper.UserMapper;
import com.prestamo_libros.model.UserEntity;
import com.prestamo_libros.repository.IUserRepository;
import com.prestamo_libros.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    private final UserMapper userMapper;

    @Transactional
    @Override
    public UserResponseDTO registerUser(UserRequestDTO request) {
        UserEntity user = userMapper.requestToUser(request);
        UserEntity userSaved = userRepository.save(user);
        return userMapper.userToResponse(userSaved);
    }

}
