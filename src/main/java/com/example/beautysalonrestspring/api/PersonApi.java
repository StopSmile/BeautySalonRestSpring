package com.example.beautysalonrestspring.api;


import com.example.beautysalonrestspring.controller.model.PersonModel;
import com.example.beautysalonrestspring.dto.PersonDto;
import com.example.beautysalonrestspring.dto.group.OnCreate;
import com.example.beautysalonrestspring.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Person management API")
@RequestMapping("/api/v1/persons")
public interface PersonApi {


    @ApiImplicitParams({
            @ApiImplicitParam(name = "login", paramType = "path", required = true, value = "User login"),
    })
    @ApiOperation("Get person")
    @GetMapping(value = "/{login}")
    @ResponseStatus(HttpStatus.OK)
    PersonModel getPerson(@PathVariable String login);

    @ApiOperation("Create person")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PersonModel createPerson(@Validated(OnCreate.class) @RequestBody PersonDto personDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "login", paramType = "path", required = true, value = "User login"),
    })
    @ApiOperation("Update person")
    @PatchMapping(value = "/{login}")
    @ResponseStatus(HttpStatus.OK)
    PersonModel updatePerson(@Validated(OnUpdate.class) @PathVariable String login, @RequestBody PersonDto personDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "login", paramType = "path", required = true, value = "User login"),
    })
    @ApiOperation("Delete person")
    @DeleteMapping(value = "/{login}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Void> deletePerson(@PathVariable String login);

    @ApiOperation("Get all persons")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PersonModel> getAllPersons();

}
