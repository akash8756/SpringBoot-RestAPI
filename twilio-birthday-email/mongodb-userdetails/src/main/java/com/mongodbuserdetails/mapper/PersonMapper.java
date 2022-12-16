package com.mongodbuserdetails.mapper;

import com.mongodbuserdetails.entity.PersonEntity;
import com.mongodbuserdetails.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonEntity modelToEntity(Person person);
    Person entityToModel(PersonEntity personEntity);

}
