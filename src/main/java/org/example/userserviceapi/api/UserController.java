package org.example.userserviceapi.api;

import org.example.userserviceapi.dto.paginate.PaginateUsersResponseDto;
import org.example.userserviceapi.dto.request.RequestUserDto;
import org.example.userserviceapi.service.UserService;
import org.example.userserviceapi.util.StandardResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<StandardResponseDto> createUser(@RequestBody RequestUserDto dto) {
        userService.createUser(dto);
        return new ResponseEntity<>(
                new StandardResponseDto(dto.getFullName()+ " was Saved!",201,null),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{userId}")
    public ResponseEntity<StandardResponseDto> updateUser(@RequestBody RequestUserDto dto , @PathVariable String userId) {
        userService.updateUser(dto,userId);
        return new ResponseEntity<>(
                new StandardResponseDto(dto.getFullName() + " was updated!",201,null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<StandardResponseDto> findUser(@PathVariable String userId) {
        return new ResponseEntity<>(
                new StandardResponseDto("User data",200,userService.findUser(userId)),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<StandardResponseDto>  deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(
                new StandardResponseDto( userId + " was Deleted!",204,null),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping(value = "/list", params = {"page", "size","searchText"})
    public ResponseEntity<StandardResponseDto> findAllUsers(
        @RequestParam int page , @RequestParam int size , @RequestParam String searchText
    ) {
        return new ResponseEntity<>(
                new StandardResponseDto( "All User Data",200,userService.findAllUsers(page, size, searchText)),
                HttpStatus.OK
        );
    }
}
