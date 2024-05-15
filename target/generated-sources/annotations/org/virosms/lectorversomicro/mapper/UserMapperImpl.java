package org.virosms.lectorversomicro.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.virosms.lectorversomicro.dto.UserDTO;
import org.virosms.lectorversomicro.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-15T20:39:14+0200",
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
