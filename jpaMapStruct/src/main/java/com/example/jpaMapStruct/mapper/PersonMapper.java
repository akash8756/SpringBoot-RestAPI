package com.example.jpaMapStruct.mapper;

import com.example.jpaMapStruct.entity.PersonEntity;
import com.example.jpaMapStruct.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE= Mappers.getMapper(PersonMapper.class);


    PersonEntity personToEntity(Person person);
    Person entityToPerson (PersonEntity personEntity);
}
