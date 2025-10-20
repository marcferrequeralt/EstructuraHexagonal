package com.estructurahexagonal.test.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estructurahexagonal.test.application.port.in.CreateUserUsecase;
import com.estructurahexagonal.test.application.port.in.GetUserUsecase;
import com.estructurahexagonal.test.domain.model.User;
import com.estructurahexagonal.test.infrastructure.controller.dto.UserRequest;
import com.estructurahexagonal.test.infrastructure.controller.dto.UserResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUsecase createUserUsecase;
    private final GetUserUsecase getUserUsecase;

    public UserController(CreateUserUsecase createUserUsecase, GetUserUsecase getUserUsecase) {
        this.createUserUsecase = createUserUsecase;
        this.getUserUsecase = getUserUsecase;
    }

    @PostMapping("/{id}")
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        final User user = new User(null, userRequest.type(), userRequest.username(), userRequest.name(), userRequest.surname(), userRequest.email(), userRequest.password(), userRequest.location(), userRequest.gender(), userRequest.age(), userRequest.description(), userRequest.isVerified(), userRequest.profilePhotoUrl(), userRequest.isPremium(), userRequest.isModerator());
        final User userCreated = createUserUsecase.createUser(user);
        return new UserResponse(userCreated.id(), userCreated.type(), userCreated.username(), userCreated.name(), userCreated.surname(), userCreated.email(), userCreated.password(), userCreated.location(), userCreated.gender(), userCreated.age(), userCreated.description(), userCreated.isVerified(), userCreated.profilePhotoUrl(), userCreated.isPremium(), userCreated.isModerator());

    }

}
