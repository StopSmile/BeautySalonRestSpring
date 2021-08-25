package com.example.beautysalonrestspring.controller.model;

import com.example.beautysalonrestspring.dto.PersonDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class PersonModel extends RepresentationModel<PersonModel> {

    @JsonUnwrapped
    private PersonDto personDto;
}
