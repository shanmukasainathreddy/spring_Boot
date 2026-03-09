package com.capgemini.service;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.Book;
import com.capgemini.entity.BorrowRecord;
import com.capgemini.entity.User;
import com.capgemini.repository.BookRepository;
import com.capgemini.repository.BorrowRecordRepository;
import com.capgemini.repository.UserRepository;

@Service
public class BorrowService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowRecordRepository borrowRepository;

    public BorrowRecord borrowBook(Long userId, Long bookId) {

        User user = userRepository.findById(userId).orElseThrow();
        Book book = bookRepository.findById(bookId).orElseThrow();

        if (!book.isAvailable()) {
            throw new RuntimeException("Book not available");
        }

        BorrowRecord record = new BorrowRecord();
        record.setUser(user); 
        record.setBook(book);
        record.setBorrowDate(LocalDate.now());
        record.setReturned(false);

        book.setAvailable(false);
        bookRepository.save(book);

        return borrowRepository.save(record);
    }
}