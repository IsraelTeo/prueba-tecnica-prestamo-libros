package com.prestamo_libros.controller;

import com.prestamo_libros.dto.loan.LoanRequestDTO;
import com.prestamo_libros.dto.loan.LoanResponseDTO;
import com.prestamo_libros.service.impl.LoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanResponseDTO> lendBooks(@RequestBody @Valid LoanRequestDTO request) {
        LoanResponseDTO loan = loanService.lendBooks(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(loan);
    }

    @PutMapping("/{loanId}/return")
    public ResponseEntity<Void> returnBooks(@PathVariable Long loanId) {
        loanService.returnLoan(loanId);
        return ResponseEntity.noContent().build();
    }
}
