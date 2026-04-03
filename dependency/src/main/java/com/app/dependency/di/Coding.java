package com.app.dependency.di;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//final :
@Component
@Data
// @Data : getter, setter, toString, equals, hashcode
// @NoArgsConstructor : 기본생성자
// @AllArgsConstructor : 초기화생성자
// @Getter
// @Setter
// @ToString
// @EqualsAndHashCode

public class Coding {

// 필드 주입을 하면 안되는 이유?
//  1. 불변 상태를 만들 수 없다.(값을 바뀔 수 있다)
//    final로 해결 x

//  2. 순환참조 발생 여부를 알 수 없다.(순환참조를 해결 못함)
//    서버 -> 컴퓨터 -> 코딩 -> 컴퓨터 -> 코딩

//     사용하면 안됨
//    @Autowired
//    final private Computer computer;

//    setter 주입 안됨
//    final private Computer computer;
//
//    @Autowired
//    public void setComputer(Computer computer) {
//        this.computer = computer;

//    생성자 주입으로 불변성을 유지하자
     final private Computer computer;

     private String type;
     private String content;

    }

