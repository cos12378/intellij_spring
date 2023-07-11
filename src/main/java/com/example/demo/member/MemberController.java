package com.example.demo.member;

import com.example.demo.User;
import com.example.demo.store.Store;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<Member>> findAll(){
        List<Member> result = memberService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable("id") Integer id){
        MemberResponseDto byId = memberService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity save(@RequestBody MemberRequestDto request) {
        memberService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id")Integer id){
        memberService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id")Integer id,
                                         @RequestBody MemberRequestDto request){
        memberService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
