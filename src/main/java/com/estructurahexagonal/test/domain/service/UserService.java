package com.estructurahexagonal.test.domain.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.estructurahexagonal.test.application.port.in.CreateUserUsecase;
import com.estructurahexagonal.test.application.port.in.GetUserUsecase;
import com.estructurahexagonal.test.application.port.out.UserRepositoryPort;
import com.estructurahexagonal.test.domain.model.User;

@Service
public class UserService implements CreateUserUsecase, GetUserUsecase{

    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User createUser(User user){
        return userRepositoryPort.save(user);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepositoryPort.findById(id);
    }
    
}
