package com.capgemini.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.BorrowRecord;
import com.capgemini.service.BorrowService;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping
    public BorrowRecord borrowBook(@RequestParam Long userId,
                                   @RequestParam Long bookId) {

        return borrowService.borrowBook(userId, bookId);
    }
}