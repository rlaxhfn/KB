package ch12.sec03.exam05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getter/Setter 메서드, equals(), hashCode(), toString() 메서드
@AllArgsConstructor // 전체 필드 초기화 생성자
@NoArgsConstructor // 기본 생성자
public class Member {
    private String id;
    private String name;
    private int age;
}
