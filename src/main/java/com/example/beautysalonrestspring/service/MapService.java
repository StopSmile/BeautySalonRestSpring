package com.example.beautysalonrestspring.service;

import com.example.beautysalonrestspring.dto.PersonDto;
import com.example.beautysalonrestspring.model.Person;

public interface MapService {

    PersonDto mapPersonToPersonDto(Person person);

    Person mapPersonDtoToPerson(PersonDto personDto);

    Person populateUserWithPresentUserDtoFields(Person person, PersonDto personDto);
}
