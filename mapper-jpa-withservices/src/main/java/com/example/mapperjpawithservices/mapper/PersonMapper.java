package com.example.mapperjpawithservices.mapper;

import com.example.mapperjpawithservices.entity.PersonEntity;
import com.example.mapperjpawithservices.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE= Mappers.getMapper(PersonMapper.class);

    Person entityToPerson (PersonEntity personEntity);
    PersonEntity personToEntity (Person person);

}
