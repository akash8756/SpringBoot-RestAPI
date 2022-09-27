package com.example.onetoonebidirection.mapper;

import com.example.onetoonebidirection.entity.AddressEntity;
import com.example.onetoonebidirection.entity.PersonEntity;
import com.example.onetoonebidirection.model.Address;
import com.example.onetoonebidirection.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonAddressMapper {
    PersonAddressMapper INSTANCE= Mappers.getMapper(PersonAddressMapper.class);

    PersonEntity personToEntity(Person person);
    AddressEntity personToEntity(Address address);

    Person entityToPerson(PersonEntity personEntity);
}
