package com.example.swagger.controller;

import com.example.swagger.dto.UserRequestDTO;
import com.example.swagger.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {


    @GetMapping("/hello")
    public String hello() {
        return "Hello, Swagger!";
    }

    // 단순 GET 요청 - 사용자 정보 조회
    @GetMapping("/user/{id}")
    public UserResponseDTO getUser(
            @Parameter(description = "조회할 사용자 ID", example = "123") @PathVariable String id) {
        return new UserResponseDTO(id, "John Doe", "johndoe@example.com");
    }

    // POST 요청 - 사용자 생성
    @PostMapping("/user")
    public UserResponseDTO createUser(
            @RequestBody // <-- Spring의 @RequestBody만 사용
            UserRequestDTO request) {
        return new UserResponseDTO("999", request.getName(), request.getEmail());
    }

    // PUT 요청 - 사용자 정보 업데이트
    @PutMapping("/user/{id}")
    public UserResponseDTO updateUser(
            @Parameter(description = "업데이트할 사용자 ID", example = "456") @PathVariable String id,
            @RequestBody // <-- Spring의 @RequestBody만 사용
            UserRequestDTO request) {
        return new UserResponseDTO(id, request.getName(), request.getEmail());
    }

    // DELETE 요청 - 사용자 삭제
    @DeleteMapping("/user/{id}")
    public Map<String, String> deleteUser(
            @Parameter(description = "삭제할 사용자 ID", example = "789") @PathVariable String id) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "User deleted successfully");
        response.put("id", id);
        return response;
    }

    // Query Parameter 사용 예제
    @GetMapping("/search")
    public Map<String, String> search(
            @Parameter(description = "검색할 키워드", example = "Java") @RequestParam String keyword) {
        Map<String, String> response = new HashMap<>();
        response.put("keyword", keyword);
        response.put("result", "Search results for " + keyword);
        return response;
    }
}
