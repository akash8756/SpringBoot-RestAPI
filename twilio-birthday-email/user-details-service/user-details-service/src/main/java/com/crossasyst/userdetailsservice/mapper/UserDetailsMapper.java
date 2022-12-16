package com.crossasyst.userdetailsservice.mapper;

import com.crossasyst.userdetailsservice.enitity.UsersEntity;
import com.crossasyst.userdetailsservice.model.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {
    UsersEntity modelToEntity (Users users);
    Users entityToModel(UsersEntity usersEntity);
}
