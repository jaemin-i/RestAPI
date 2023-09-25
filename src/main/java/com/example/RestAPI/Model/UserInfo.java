package com.example.RestAPI.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter, setter, toString 등 생략가능
@NoArgsConstructor //기본 생성자 생성
@AllArgsConstructor //전체 변수 포함 생성자 생성
public class UserInfo {
    private int seq;
    private String username;
    private String email;
    private String address1;
    private String address2;
}
