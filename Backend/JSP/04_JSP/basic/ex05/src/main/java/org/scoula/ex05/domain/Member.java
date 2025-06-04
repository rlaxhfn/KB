package org.scoula.ex05.domain;

public class Member {
    private String name;
    private String userid; // 캡슐화
    public Member() {} // 기본 생성자
    public Member(String name, String userid) {
        this.name = name;
        this.userid = userid;
    } // 매개변수 생성자

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    } // getter/setter 메서드
}
