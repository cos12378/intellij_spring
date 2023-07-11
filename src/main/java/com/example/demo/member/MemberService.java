package com.example.demo.member;

import com.example.demo.hobby.Hobby;
import com.example.demo.store.Store;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private static final List<MemberResponseDto> members = new ArrayList<>();

    public List<Member> findAll(){
        return Store.members;
    }

    public MemberResponseDto findById(Integer id) {
        Member member = null;
        for (int i = 0; i < Store.members.size(); i++) {
            if (Store.members.get(i).getId().equals(id)) {
                member = Store.members.get(i);
                break; // 원하는 멤버를 찾았으므로 반복문 종료
            }
        }

        List<Hobby> hobbyList = new ArrayList<>();
        for (int i = 0; i < Store.hobbies.size(); i++) {
            if (Store.hobbies.get(i).getMember().getId().equals(id)) {
                hobbyList.add(Store.hobbies.get(i));
            }
        }

        return MemberResponseDto.of(member,hobbyList);
    }


    public void save(MemberRequestDto request) {
       Store.members.add(MemberRequestDto.toEntity(request));
    }

    public void delete(Integer id) {
                Store.members.remove(findById(id));
    }

    public void update(Integer id, MemberRequestDto request) {
       Member member = null;
        for (int i = 0; i < Store.members.size(); i++) {
            if (Store.members.get(i).getId().equals(id)) {
                member = Store.members.get(i);
                break; // 원하는 멤버를 찾았으므로 반복문 종료
            }
        }
       member.setName(request.getName());
       member.setAge(request.getAge());

    }



}
