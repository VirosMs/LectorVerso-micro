package org.virosms.lectorversomicro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.virosms.lectorversomicro.dto.UserDTO;
import org.virosms.lectorversomicro.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mappings({
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "name", source = "name"),
        @Mapping(target = "email", source = "email")
    })
    UserDTO toUserDTO(User user);
}
