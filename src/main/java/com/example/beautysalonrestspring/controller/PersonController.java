package com.example.beautysalonrestspring.controller;

import com.example.beautysalonrestspring.api.PersonApi;
import com.example.beautysalonrestspring.controller.Assembler.PersonAssembler;
import com.example.beautysalonrestspring.controller.model.PersonModel;
import com.example.beautysalonrestspring.dto.PersonDto;
import com.example.beautysalonrestspring.dto.group.OnCreate;
import com.example.beautysalonrestspring.dto.group.OnUpdate;
import com.example.beautysalonrestspring.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class PersonController implements PersonApi {

    private final PersonService personService;
    private final PersonAssembler personAssembler;


    public PersonModel getPerson(String login) {
        PersonDto personDto = personService.getPerson(login);
        return personAssembler.toModel(personDto);
    }

    public List<PersonModel> getAllPersons() {
        List<PersonDto> personDtoList = personService.getAllPerson();
        List<PersonModel> personModelList = new ArrayList<>();
        for (PersonDto personDto : personDtoList) {
            personModelList.add(personAssembler.toModel(personDto));
        }
        return personModelList;
    }

    public PersonModel createPerson(PersonDto personDto) {
        PersonDto OutPersonDto = personService.createPerson(personDto);
        return personAssembler.toModel(OutPersonDto);
    }

    public PersonModel updatePerson(String login, PersonDto personDto) {
        PersonDto OutPersonDto = personService.updatePerson(login, personDto);
        return personAssembler.toModel(OutPersonDto);
    }

    public ResponseEntity<Void> deletePerson(String login) {
        personService.deletePerson(login);
        return ResponseEntity.noContent().build();
    }
}
