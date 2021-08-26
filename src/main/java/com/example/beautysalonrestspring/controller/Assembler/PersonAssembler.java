package com.example.beautysalonrestspring.controller.Assembler;

import com.example.beautysalonrestspring.controller.PersonController;
import com.example.beautysalonrestspring.controller.model.PersonModel;
import com.example.beautysalonrestspring.dto.PersonDto;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.*;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class PersonAssembler extends RepresentationModelAssemblerSupport<PersonDto, PersonModel> {

    public static final String GET_USER = "get_user";
    public static final String CREATE_USER = "create_user";
    public static final String UPDATE_USER = "update_user";
    public static final String DELETE_USER = "delete_user";
    public static final String GET_ALL_USERS = "get_all_users";


    public PersonAssembler() {
        super(PersonController.class,PersonModel.class);
    }

    @Override
    public PersonModel toModel(PersonDto entity) {
        PersonModel personModel = new PersonModel(entity);

        Link get = linkTo(methodOn(PersonController.class).getPerson(entity.getLogin())).withRel(GET_USER);
        Link create = linkTo(methodOn(PersonController.class).createPerson(entity)).withRel(CREATE_USER);
        Link update = linkTo(methodOn(PersonController.class).updatePerson(entity.getLogin(),entity)).withRel(UPDATE_USER);
        Link delete = linkTo(methodOn(PersonController.class).deletePerson(entity.getLogin())).withRel(DELETE_USER);
        Link getAllUsers = linkTo(methodOn(PersonController.class).getAllPersons()).withRel(GET_ALL_USERS);

        personModel.add(get,create,update,delete,getAllUsers);


        return personModel;
    }
}
