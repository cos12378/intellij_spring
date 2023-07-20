package com.example.demo.members.controller;


import com.example.demo.config.domain.entity.MemberLogin;
import com.example.demo.config.repository.MemberLoginRepository;
import com.example.demo.members.domain.entity.Member;
import com.example.demo.members.domain.request.LoginRequest;
import com.example.demo.members.domain.request.SignupRequest;
import com.example.demo.members.domain.response.LoginResponse;
import com.example.demo.members.domain.response.MemberResponse;
import com.example.demo.members.repository.MemberRepository;
import com.example.demo.members.service.MemberService;
import com.example.demo.todos.domain.entity.Todo;
import com.example.demo.todos.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MembersController {

    private final MemberService service;
    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest loginRequest){
        return service.login(loginRequest);
    }
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(
            @RequestBody SignupRequest request){
        service.insert(request);
    }

    @GetMapping
    public Map<String , Object> getAll(
            @RequestParam(required = false, defaultValue = "0", name = "page")
            Integer page,
            @RequestParam(required = false, defaultValue = "3", name = "size")
            Integer size
    ){
        Page<MemberResponse> all = service.findAll(PageRequest.of(page, size));
        long totalElements = all.getTotalElements();
        int totalPages = all.getTotalPages();
        List<MemberResponse> content = all.getContent();
        Map<String , Object> map = new HashMap<>();
        map.put("totalElements",totalElements);
        map.put("totalPages",totalPages);
        map.put("content",content);
        return map;


    }
}
