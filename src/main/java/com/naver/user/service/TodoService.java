package com.naver.user.service;

import com.naver.user.dao.TodoDao;
import com.naver.user.domain.dto.TodoJoinUser;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoService {
    private final TodoDao todoDao;

    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public List<TodoJoinUser> findAll(){
        return todoDao.findAll();
    }

    public int insert(Integer uid, String content){
        //Dao에 있는 기능을 끌어옴
        return todoDao.insert(uid, content);
    }

    public List<TodoJoinUser> findByKeyword(String keyword){
        return todoDao.findByKeyword(keyword);
    }
}
