package ch.csbe.productstore.mapper;

import ch.csbe.productstore.dto.user.UserCreateDto;
import ch.csbe.productstore.dto.user.UserShowDto;
import ch.csbe.productstore.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserCreateDto dto);

    UserShowDto toShowDto(User user);
}
