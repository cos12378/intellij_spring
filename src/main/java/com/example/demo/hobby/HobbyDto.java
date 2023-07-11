package com.example.demo.hobby;

import com.example.demo.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HobbyDto {
    private String hobbies;

    public static Hobby toHobby(Member member, String hobbyName){
        return new Hobby(hobbyName, member);
    }
}
