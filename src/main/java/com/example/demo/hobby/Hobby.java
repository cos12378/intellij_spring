package com.example.demo.hobby;

import com.example.demo.member.Member;
import com.example.demo.store.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class Hobby {
    private Integer Id;
    private String name;
    private Member member;

    public Hobby(String name, Member member) {
        Id = Store.hobbyIndex++;
        this.name = name;
        this.member = member;
    }

}
