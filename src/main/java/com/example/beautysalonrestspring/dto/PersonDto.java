package com.example.beautysalonrestspring.dto;

import com.example.beautysalonrestspring.model.enums.Role;
import com.example.beautysalonrestspring.model.enums.ServiceType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.example.beautysalonrestspring.dto.group.OnCreate;
import com.example.beautysalonrestspring.dto.group.OnUpdate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class PersonDto {

    @NotBlank(message = "'firstName' shouldn't be empty", groups = OnCreate.class)
    private String firstName;

    @NotBlank(message = "'lastName' shouldn't be empty", groups = OnCreate.class)
    private String lastName;

    @Null(message = "'login' shouldn't be absent in request",groups = OnUpdate.class)
    @NotBlank(message = "'login' shouldn't be empty", groups = OnCreate.class)
    private String login;

    @Null(message = "'password' shouldn't be absent in request",groups = OnUpdate.class)
    @NotBlank(message = "'password' shouldn't be empty", groups = OnCreate.class)
    private String password;

    @Null(message = "'repeatPassword' shouldn't be absent in request",groups = OnUpdate.class)
    @NotBlank(message = "'repeatPassword' shouldn't be empty", groups = OnCreate.class)
    private String repeatPassword;

    @Email(message = "'email' wrong email format", groups = OnCreate.class)
    @NotBlank(message = "'email' shouldn't be empty", groups = OnCreate.class)
    private String email;

    @NotNull(message = "'role' shouldn't be absent in request",groups = OnUpdate.class)
    @NotNull(message = "'role' shouldn't be absent in request",groups = OnCreate.class)
    private Role role;

    private ServiceType serviceType;

}
