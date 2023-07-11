package com.example.demo.hobby;
import com.example.demo.member.Member;
import com.example.demo.member.MemberResponseDto;
import com.example.demo.store.Store;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class HobbyService {
    public void create(Integer memberId, HobbyDto request) {
        List<Member> members = Store.members;
        Member targetmember = null;
        for (Member member : members) {
            if (member.getId().equals(memberId)) {
                targetmember = member;
            }
        }
        List<Hobby> hobbyList = new ArrayList<>();
        String[] hobbies = request.getHobbies().split(",");
        for (String hobbyName : hobbies) {
            Hobby hobby = HobbyDto.toHobby(targetmember, hobbyName);
            hobbyList.add(hobby);
        }
        Store.hobbies.addAll(hobbyList);
    }
}

