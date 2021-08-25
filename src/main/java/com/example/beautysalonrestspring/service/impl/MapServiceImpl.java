package com.example.beautysalonrestspring.service.impl;

import com.example.beautysalonrestspring.dto.PersonDto;
import com.example.beautysalonrestspring.model.Person;
import com.example.beautysalonrestspring.service.MapService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class MapServiceImpl implements MapService {

    @Override
    public PersonDto mapPersonToPersonDto(Person person) {
        return PersonDto.builder()
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .login(person.getLogin())
                .email(person.getEmail())
                .role(person.getRole())
                .serviceType(person.getServiceType())
                .build();
    }

    @Override
    public Person mapPersonDtoToPerson(PersonDto personDto) {
        return Person.builder()
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .login(personDto.getLogin())
                .email(personDto.getEmail())
                .password(personDto.getPassword())
                .role(personDto.getRole())
                .serviceType(personDto.getServiceType())
                .build();
    }

    @Override
    public Person populateUserWithPresentUserDtoFields(Person person, PersonDto personDto) {
        String firstName = personDto.getFirstName();
        if (Objects.nonNull(firstName)){
            person.setFirstName(firstName);
        }
        String lastName = personDto.getLastName();
        if (Objects.nonNull(lastName)){
            person.setLastName(lastName);
        }

        return person;
    }
}
