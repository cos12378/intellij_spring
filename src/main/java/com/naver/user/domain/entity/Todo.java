package com.naver.user.domain.entity;

public class Todo {
    private Integer id;
    private String content;
    private String createAt;
    private boolean checked;
    private Integer userId;
    private Integer heart;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHeart() {
        return heart;
    }

    public void setHeart(Integer heart) {
        this.heart = heart;
    }

    // 전체 생성자, getter
    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getCreateAt() {
        return createAt;
    }

    public boolean isChecked() {
        return checked;
    }

    public Todo(Integer id, String content, String createAt, boolean checked) {
        this.id = id;
        this.content = content;
        this.createAt = createAt;
        this.checked = checked;
    }


}
