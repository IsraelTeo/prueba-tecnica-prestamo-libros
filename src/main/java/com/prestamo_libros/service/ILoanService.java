package com.prestamo_libros.service;

import com.prestamo_libros.dto.loan.LoanRequestDTO;
import com.prestamo_libros.dto.loan.LoanResponseDTO;

public interface ILoanService {

    LoanResponseDTO lendBooks(LoanRequestDTO request);

    void returnLoan(Long loanId);

}
