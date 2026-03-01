package com.capgemini.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.library.entity.LibraryBranch;
import com.capgemini.library.service.BranchService;

@RestController
@RequestMapping("/api/v1/branches")
//@RequiredArgsConstructor
public class BranchController {
	@Autowired

    private BranchService branchService;

    @PostMapping
    public ResponseEntity<LibraryBranch> createBranch(@RequestBody LibraryBranch branch) {
        return new ResponseEntity<>(branchService.addBranch(branch), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryBranch> getBranchById(@PathVariable Long id) {
        return ResponseEntity.ok(branchService.getBranchById(id));
    }

    @GetMapping
    public ResponseEntity<List<LibraryBranch>> listBranches() {
        return ResponseEntity.ok(branchService.getAllBranches());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryBranch> updateBranch(@PathVariable Long id, @RequestBody LibraryBranch branch) {
        return ResponseEntity.ok(branchService.updateBranch(id, branch));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }
}