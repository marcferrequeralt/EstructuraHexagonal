package com.estructurahexagonal.test.infrastructure.persistance;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.estructurahexagonal.test.application.port.out.UserRepositoryPort;
import com.estructurahexagonal.test.domain.model.User;

@Repository
public class CosmosUserRepositoryAdapter implements UserRepositoryPort {

    private final SpringDataUserRepository springDataUserRepository;

    public CosmosUserRepositoryAdapter(SpringDataUserRepository springDataUserRepository) {

        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = new UserEntity(user.id(), user.type(), user.username(), user.name(), user.surname(),
                user.email(), user.password(), user.location(), user.gender(), user.age(), user.description(),
                user.isVerified(), user.profilePhotoUrl(), user.isPremium(), user.isModerator()); // AQUI IRIA EL MAPPER
        final UserEntity savedUser = springDataUserRepository.save(userEntity);
        return new User(savedUser.getId(), savedUser.getType(), savedUser.getUsername(), savedUser.getName(),
                savedUser.getSurname(), savedUser.getEmail(), savedUser.getPassword(), savedUser.getLocation(),
                savedUser.getGender(), savedUser.getAge(), savedUser.getDescription(), savedUser.isVerified(),
                savedUser.getProfilePhotoUrl(), savedUser.isPremium(), savedUser.isModerator()); // AQUI IRIA EL MAPPER
    }

    @Override
    public Optional<User> findById(String id) {
        final UserEntity savedUser = springDataUserRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return Optional.of(new User(savedUser.getId(), savedUser.getType(), savedUser.getUsername(), savedUser.getName(),
                savedUser.getSurname(), savedUser.getEmail(), savedUser.getPassword(), savedUser.getLocation(),
                savedUser.getGender(), savedUser.getAge(), savedUser.getDescription(), savedUser.isVerified(),
                savedUser.getProfilePhotoUrl(), savedUser.isPremium(), savedUser.isModerator()));
    }

}
