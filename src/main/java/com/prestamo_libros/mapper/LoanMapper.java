package com.prestamo_libros.mapper;

import com.prestamo_libros.dto.loan.LoanResponseDTO;
import com.prestamo_libros.model.Loan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoanMapper {

    private final UserMapper userMapper;

    private final BookMapper bookMapper;

    public LoanResponseDTO loanToResponse(Loan loan) {
        return LoanResponseDTO.builder()
                .id(loan.getId())
                .user(userMapper.userToResponse(loan.getUser()))
                .books(
                        loan.getBooks().stream()
                        .map(bookMapper::bookToResponse)
                        .toList()
                )
                .loanDate(loan.getLoanDate())
                .returned(loan.isReturned())
                .build();
    }


}
