package com.example.RestAPI.Repository;

import com.example.RestAPI.Model.UserInfo;
import lombok.Value;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //해당 클래스가 Repository로 사용됨을 Framework에 알림
@Mapper
public interface UserRepository {
    List<UserInfo> findAll();

    void setUser(UserInfo userInfo);

    UserInfo findUser(int seq);

    void updateUser(UserInfo userInfo);

    void deleteUser(int seq);
}
