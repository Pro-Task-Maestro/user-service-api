package org.example.userserviceapi.dto.paginate;

import lombok.*;
import org.example.userserviceapi.dto.reponse.ResponseUserDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaginateUsersResponseDto {
    private long count;
    private List<ResponseUserDto> dataList;
}
