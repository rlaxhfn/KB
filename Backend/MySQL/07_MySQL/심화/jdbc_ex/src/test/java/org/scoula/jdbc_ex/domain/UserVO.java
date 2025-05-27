package org.scoula.jdbc_ex.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private String id;
    private String password;
    private String name;
    private String role;
} // lombok 기본 정의
