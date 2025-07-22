package com.prestamo_libros.mapper;

import com.prestamo_libros.dto.user.UserRequestDTO;
import com.prestamo_libros.dto.user.UserResponseDTO;
import com.prestamo_libros.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity requestToUser(UserRequestDTO request) {
        return UserEntity.builder()
                .name(request.name())
                .lastName(request.lastName())
                .dni(request.dni())
                .build();
    }

    public UserResponseDTO userToResponse(UserEntity user){
        return UserResponseDTO.builder()
                .id(user.getId())
                .fullName(user.getName() + " " + user.getLastName())
                .dni(user.getDni())
                .build();
    }
}
