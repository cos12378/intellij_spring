package com.example.demo.hobby;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HobbyResponseDto {
    private Integer id;
    private String name;
    public static HobbyResponseDto of(Hobby hobby) {
        return new HobbyResponseDto(hobby.getId(), hobby.getName());
    }
}