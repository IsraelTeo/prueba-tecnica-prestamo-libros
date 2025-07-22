package com.prestamo_libros.service.impl;

import com.prestamo_libros.dto.loan.LoanRequestDTO;
import com.prestamo_libros.dto.loan.LoanResponseDTO;
import com.prestamo_libros.mapper.LoanMapper;
import com.prestamo_libros.model.Book;
import com.prestamo_libros.model.Loan;
import com.prestamo_libros.model.UserEntity;
import com.prestamo_libros.repository.IBookRepository;
import com.prestamo_libros.repository.ILoanRepository;
import com.prestamo_libros.repository.IUserRepository;
import com.prestamo_libros.service.ILoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanService implements ILoanService {

    private final ILoanRepository loanRepository;

    private final IUserRepository userRepository;

    private final IBookRepository bookRepository;

    private final LoanMapper loanMapper;

    @Override
    public LoanResponseDTO lendBooks(LoanRequestDTO request) {
        UserEntity user = findUserOrThrow(request.userId());
        List<Book> books = findAndValidateBooksOrThrow(request.bookIds());
        markBooksAsUnavailable(books);

        Loan loan = createLoan(user, books);
        loanRepository.save(loan);
        bookRepository.saveAll(books);

        return loanMapper.loanToResponse(loan);
    }

    @Override
    public void returnLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        if (loan.isReturned()) {
            throw new RuntimeException("This loan has already been returned");
        }

        loan.getBooks().forEach(book -> book.setAvailable(true));

        loan.setReturned(true);

        bookRepository.saveAll(loan.getBooks());
        loanRepository.save(loan);
    }

    private UserEntity findUserOrThrow(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private List<Book> findAndValidateBooksOrThrow(List<Long> bookIds) {
        List<Book> foundBooks = bookRepository.findAllById(bookIds);

        Set<Long> foundIds = foundBooks.stream()
                .map(Book::getId)
                .collect(Collectors.toSet());

        List<Long> missingIds = bookIds.stream()
                .filter(id -> !foundIds.contains(id))
                .toList();

        if (!missingIds.isEmpty()) {
            throw new RuntimeException("Books not found: " + missingIds);
        }

        return foundBooks;
    }

    private void markBooksAsUnavailable(List<Book> books) {
        books.forEach(book -> book.setAvailable(false));
    }

    private Loan createLoan(UserEntity user, List<Book> books) {
        return Loan.builder()
                .user(user)
                .books(books)
                .loanDate(LocalDate.now())
                .returned(false)
                .build();
    }
}
