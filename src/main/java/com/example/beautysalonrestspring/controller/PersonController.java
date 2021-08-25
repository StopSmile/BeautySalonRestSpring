package com.example.beautysalonrestspring.controller;

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
@Api(tags = "Person management API")
@RequestMapping("/api/v1")
public class PersonController {

    private final PersonService personService;
    private final PersonAssembler personAssembler;


    @ApiImplicitParams({
            @ApiImplicitParam(name = "login", paramType = "path", required = true, value = "User login"),
    })
    @ApiOperation("Get person")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/persons/{login}")
    public PersonModel getPerson(@PathVariable String login) {
        PersonDto personDto = personService.getPerson(login);
        return personAssembler.toModel(personDto);
    }


    @ApiOperation("Get all persons")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/persons")
    public List<PersonModel> getPersonDtoList() {
        List<PersonDto> personDtoList = personService.getAllPerson();
        List<PersonModel> personModelList = new ArrayList<>();
        for (PersonDto personDto : personDtoList) {
            personModelList.add(personAssembler.toModel(personDto));
        }
        return personModelList;
    }

    @ApiOperation("Create person")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/persons")
    public PersonModel createPerson(@RequestBody @Validated(OnCreate.class) PersonDto personDto) {
        PersonDto OutPersonDto = personService.createPerson(personDto);
        return personAssembler.toModel(OutPersonDto);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "login", paramType = "path", required = true, value = "User login"),
    })
    @ApiOperation("Update person")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "persons/{login}")
    public PersonModel updatePerson(@PathVariable String login, @RequestBody @Validated(OnUpdate.class) PersonDto personDto) {
        PersonDto OutPersonDto = personService.updatePerson(login, personDto);
        return personAssembler.toModel(OutPersonDto);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "login", paramType = "path", required = true, value = "User login"),
    })
    @ApiOperation("Delete person")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/persons/{login}")
    public ResponseEntity<Void> deletePerson(@PathVariable String login) {
        personService.deletePerson(login);
        return ResponseEntity.noContent().build();
    }
}
