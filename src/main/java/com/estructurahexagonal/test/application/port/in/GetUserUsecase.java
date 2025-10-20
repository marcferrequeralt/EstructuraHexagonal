package com.estructurahexagonal.test.application.port.in;

import java.util.Optional;

import com.estructurahexagonal.test.domain.model.User;

public interface GetUserUsecase {
    Optional<User> findById(String id);
}