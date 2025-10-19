package com.estructurahexagonal.test.domain.service;

import org.springframework.stereotype.Service;

import com.estructurahexagonal.test.application.port.in.CreateUserUsecase;
import com.estructurahexagonal.test.application.port.out.UserRepositoryPort;
import com.estructurahexagonal.test.domain.model.User;

@Service
public class UserService implements CreateUserUsecase{

    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User createUser(User user){
        return userRepositoryPort.save(user);
    }
    
}
