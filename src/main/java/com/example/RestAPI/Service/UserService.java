package com.example.RestAPI.Service;

import com.example.RestAPI.Model.UserInfo;
import com.example.RestAPI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //해당 클래스가 Service로 사용됨을 Framework에 알림
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserInfo> findAll() {
        List<UserInfo> a = userRepository.findAll();
        System.out.println(a);
        return userRepository.findAll();
    }

    public void setUser(UserInfo userInfo) {
        userRepository.setUser(userInfo);
    }

    public UserInfo findUser(int seq) {
        return userRepository.findUser(seq);
    }

    public void updateUser(UserInfo userInfo) {
        userRepository.updateUser(userInfo);
    }

    public void deleteUser(int seq) {
        userRepository.deleteUser(seq);
    }
}
