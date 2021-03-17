package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor //생성자
@NoArgsConstructor //기본생성자
@Entity
//@Table(name = "user") //클래스명과 테이블명이 같으면 생략 가능
//@Table(schema="adminpage", name="user")
public class User  {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //키 전략 설정
    private Long id;

    //@Column(name = "account") //변수의 명과 컬럼명이 같으면 생략 가
    private String account; //varchar

    private String password;

    private String status;

    private String email;

    private String phoneNumber; //phone_number 스네이크케이스로 생성

    private LocalDateTime createdAt; //created_at

    private String createdBy; //created_by

    private LocalDateTime updatedAt; //update_at

    private String updatedBy; //update_by

}
