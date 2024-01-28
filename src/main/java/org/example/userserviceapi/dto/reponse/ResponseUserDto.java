package org.example.userserviceapi.dto.reponse;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseUserDto {
    private String userId;
    private String fullName;
    private String email;
    private String avatarUrl;
    private boolean status;
}
