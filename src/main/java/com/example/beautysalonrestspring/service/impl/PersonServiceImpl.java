package com.example.beautysalonrestspring.service.impl;

import com.example.beautysalonrestspring.dto.PersonDto;
import com.example.beautysalonrestspring.exception.PasswordAndRepeatPasswordException;
import com.example.beautysalonrestspring.exception.UserAlreadyExistsException;
import com.example.beautysalonrestspring.exception.UserNotFoundException;
import com.example.beautysalonrestspring.model.Person;
import com.example.beautysalonrestspring.repository.PersonRepository;
import com.example.beautysalonrestspring.service.MapService;
import com.example.beautysalonrestspring.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final MapService mapService;

    @Override
    public PersonDto getPerson(String login) {
        log.info("Finding user by login...");
        Person person = personRepository.findByLogin(login).orElseThrow(UserNotFoundException::new);
        log.info("Person with {} login find", login);
        return mapService.mapPersonToPersonDto(person);
    }

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        log.info("Creating person with login {}", personDto.getLogin());
        if (personRepository.existsByLogin(personDto.getLogin())) {
            throw new UserAlreadyExistsException();
        }
        if (!personDto.getPassword().equals(personDto.getRepeatPassword())){
            throw new PasswordAndRepeatPasswordException();
        }
        Person person = mapService.mapPersonDtoToPerson(personDto);
        person = personRepository.save(person);
        log.info("Person with {} login, {} id successfully created", person.getLogin(), person.getId());
        return mapService.mapPersonToPersonDto(person);
    }

    @Override
    public PersonDto updatePerson(String login, PersonDto personDto) {
        log.info("Updating Person with login {}", login);
        Person persistedPerson = personRepository.findByLogin(login)
                .orElseThrow(UserNotFoundException::new);
        persistedPerson = mapService.populateUserWithPresentUserDtoFields(persistedPerson, personDto);
        Person storedPerson = personRepository.save(persistedPerson);
        log.info("Person with {} login successfully updated", storedPerson.getLogin());
        return mapService.mapPersonToPersonDto(persistedPerson);
    }

    @Override
    public void deletePerson(String login) {
        log.info("deleteUser with login {}", login);
        Person person = personRepository.findByLogin(login).orElseThrow(UserNotFoundException::new);
        personRepository.delete(person);
        log.info("Used with {} login successfully deleted", login);

    }

    @Override
    public List<PersonDto> getAllPerson() {
        List<Person> personList = personRepository.findAll();
        List<PersonDto> personDtoList = new ArrayList<>();
        for (Person person : personList) {
            personDtoList.add(mapService.mapPersonToPersonDto(person));
        }
        return personDtoList;
    }
}
