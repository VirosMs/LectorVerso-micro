package org.virosms.lectorversomicro.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.virosms.lectorversomicro.entity.User;
import org.virosms.lectorversomicro.entity.dto.UserDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-17T22:19:21+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String email = null;

        id = user.getId();
        name = user.getName();
        email = user.getEmail();

        UserDTO userDTO = new UserDTO( id, name, email );

        return userDTO;
    }
}
