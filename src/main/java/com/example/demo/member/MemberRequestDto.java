package com.example.demo.member;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class MemberRequestDto {
    private final String name;
    private final Integer age;
    public static Member toEntity(MemberRequestDto request) {return new Member(request.getName(), request.getAge());}
}