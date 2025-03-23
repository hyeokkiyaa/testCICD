package com.example.swagger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDTO {

    @Schema(description = "사용자 ID", example = "123")
    private String id;

    @Schema(description = "사용자 이름", example = "Alice")
    private String name;

    @Schema(description = "사용자 이메일", example = "alice@example.com")
    private String email;
}