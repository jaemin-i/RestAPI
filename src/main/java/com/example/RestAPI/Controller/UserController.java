package com.example.RestAPI.Controller;

import com.example.RestAPI.Model.UserInfo;
import com.example.RestAPI.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

@RestController //Controller, ResponseBody 결합 -> 문자열, JSON등 전송가능
@RequiredArgsConstructor //final 혹은 @NotNull이 붙은 필드의 생성자를 자동으로 생성
@RequestMapping("/api") //http request로 들어오는 url을 특정 클래스나 메소드로 연결(매핑)
public class UserController {

    //@Autowired //의존성 주입???
    private final UserService userService;

    @GetMapping("/users") //http get 요청을 핸들러 메소드로 연결(매핑)
    public ResponseEntity<List<UserInfo>> findAll() {
        ResponseEntity<List<UserInfo>> a = new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        System.out.println(a);
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{seq}")
    public ResponseEntity<Object> findUser(@PathVariable String seq) { //@PathVariable = url의 변수를 처리해줌
        UserInfo userInfo = userService.findUser(Integer.parseInt(seq));

        if (userInfo != null) {
            return new ResponseEntity<>(userInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("검색결과가 없습니다.", HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/users")
    public void setUser(@RequestBody UserInfo userInfo) {
        userService.setUser(userInfo);
    }

    @PatchMapping("/users/{seq}")
    public ResponseEntity<Object> updateUser(@PathVariable String seq, @RequestBody UserInfo userInfo) {
        UserInfo isUser = userService.findUser(Integer.parseInt(seq));

        if (isUser == null) {
            return new ResponseEntity<>("유저 정보가 없습니다.", HttpStatus.NOT_FOUND);
        }
        else {
            userService.updateUser(userInfo);
            return new ResponseEntity<>("유저 정보 업데이트 완료", HttpStatus.OK);
        }
    }

    @DeleteMapping("/users/{seq}")
    public ResponseEntity<Object> deleteUser(@PathVariable String seq){
        UserInfo isUser = userService.findUser(Integer.parseInt(seq));

        if(isUser == null) {
            return new ResponseEntity<>("유저 정보가 없습니다.", HttpStatus.NOT_FOUND);
        }
        else {
            userService.deleteUser(Integer.parseInt(seq));
            return new ResponseEntity<>("유저 정보 삭제 완료", HttpStatus.OK);
        }
    }
}
