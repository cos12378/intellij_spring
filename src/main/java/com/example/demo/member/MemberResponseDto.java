package com.example.demo.member;

import com.example.demo.hobby.Hobby;
import com.example.demo.hobby.HobbyResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto{
    private Integer id;
    private String name;
    private Integer age;
    List<HobbyResponseDto> hobbies = new ArrayList<>();
    public static MemberResponseDto of(Member member, List<Hobby> hobbies) {
        List<HobbyResponseDto> hobbyResponseDtoList = hobbies.stream()
                .map(HobbyResponseDto::of)
                .collect(Collectors.toList());
        return new MemberResponseDto(member.getId(), member.getName(), member.getAge(), hobbyResponseDtoList);
    }
}
