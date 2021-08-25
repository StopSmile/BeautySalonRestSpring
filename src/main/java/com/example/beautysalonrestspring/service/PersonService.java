package com.example.beautysalonrestspring.service;

import com.example.beautysalonrestspring.dto.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto getPerson(String login);

    PersonDto createPerson(PersonDto personDto);

    PersonDto updatePerson(String login,PersonDto personDto);

    void deletePerson(String login);

    List<PersonDto> getAllPerson();
}
