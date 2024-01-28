package org.example.userserviceapi.service;

import org.example.userserviceapi.dto.paginate.PaginateUsersResponseDto;
import org.example.userserviceapi.dto.reponse.ResponseUserDto;
import org.example.userserviceapi.dto.request.RequestUserDto;

public interface UserService {
    public void createUser(RequestUserDto dto);

    public void updateUser(RequestUserDto dto , String userId);

    public ResponseUserDto findUser(String userId);

    public void deleteUser(String userId);

    public PaginateUsersResponseDto findAllUsers(int page , int size , String searchText);
}
