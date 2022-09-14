package com.jpa.mapper;

import com.jpa.entity.Person;
import com.jpa.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {
       Class<? extends PersonMapper> INSTANCE = Mappers.getMapperClass(PersonMapper.class);
    PersonEntity personToEntity (Person person);

}