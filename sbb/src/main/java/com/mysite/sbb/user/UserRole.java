package com.mysite.sbb.user;

import lombok.Getter;

@Getter // 상수형 자료이므로 setter 없이 getter만
public enum UserRole { // 열거자료형 enum
    ADMIN("ROLE_ADMIN"), USER("ROLE_USER");
    // ADMIN의 값은 ROLE_ADMIN, USER의 값을  ROLE_USER
    UserRole(String value){
        this.value = value;
    }

    private String value;
}
