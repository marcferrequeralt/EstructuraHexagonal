package com.estructurahexagonal.test.application.port.out;

import com.estructurahexagonal.test.domain.model.User;

public interface UserRepositoryPort {
    User save(User user);
}
