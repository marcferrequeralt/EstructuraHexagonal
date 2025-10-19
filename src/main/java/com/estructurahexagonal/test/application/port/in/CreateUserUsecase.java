package com.estructurahexagonal.test.application.port.in;

import com.estructurahexagonal.test.domain.model.User;

public interface CreateUserUsecase {
    User createUser(User user);
}
