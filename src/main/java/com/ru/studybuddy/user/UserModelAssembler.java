package com.ru.studybuddy.user;

import lombok.NonNull;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<UserDto>> {
    @Override
    @NonNull
    public EntityModel<UserDto> toModel(User user) {
        return EntityModel.of(new UserDto(user.getId(), user.getName(), user.getEmail(), user.getDepartment().getTitle(), user.getSpecialty().getTitle(), user.getGroup().getId(), user.getGroup().getNumber()),
                linkTo(methodOn(UserController.class).getStudents(user.getName(), user.getDepartment().getTitle(), user.getSpecialty().getTitle(), user.getGroup().getId())).withSelfRel()/*,
                linkTo(methodOn(UserController.class).one(user.getId())).withRel("user")*/);
    }
}
