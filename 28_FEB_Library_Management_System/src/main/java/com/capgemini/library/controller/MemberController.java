package com.capgemini.library.controller;

import java.lang.reflect.Member;
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

import com.capgemini.library.entity.Loan;
import com.capgemini.library.service.LoanService;
import com.capgemini.library.service.MemberService;

@RestController
@RequestMapping("/api/v1/members")
//@RequiredArgsConstructor
public class MemberController {
	@Autowired

    private MemberService memberService;
	@Autowired

	private  LoanService loanService;

//    @PostMapping
//    public ResponseEntity<Member> createMember(@RequestBody Member member) {
//        return new ResponseEntity<>(memberService.addMember(member), HttpStatus.CREATED);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<com.capgemini.library.entity.Member> getMemberById(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @GetMapping
    public ResponseEntity<List<com.capgemini.library.entity.Member>> listMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
//        return ResponseEntity.ok(memberService.updateMember(id, member));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrDisableMember(@PathVariable Long id) {
        memberService.deleteOrDisableMember(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{memberId}/loans")
    public ResponseEntity<List<Loan>> getLoansByMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(loanService.getLoansByMember(memberId));
    }
}