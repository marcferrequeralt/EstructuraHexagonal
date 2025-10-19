package com.estructurahexagonal.test.infrastructure.persistance;

import org.springframework.data.annotation.Id;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import lombok.Getter;

@Getter
@Container(containerName = "swaply-container")
public final class UserEntity {


    @Id

    private final String id;

    @PartitionKey
    private final String type;
    private final String username;
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final String location;
    private final String gender;
    private final int age;
    private final String description;
    private final boolean isVerified;
    private final String profilePhotoUrl;
    private final boolean isPremium;
    private final boolean isModerator;

    public UserEntity(
        String id,
        String type,
        String username,
        String name,
        String surname,
        String email,
        String password,
        String location,
        String gender,
        int age,
        String description,
        Boolean isVerified,
        String profilePhotoUrl,
        Boolean isPremium,
        Boolean isModerator
    ) {
        this.id = id;
        this.type = type;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.location = location;
        this.gender = gender;
        this.age = age;
        this.description = description;
        this.isVerified = isVerified;
        this.profilePhotoUrl = profilePhotoUrl;
        this.isPremium = isPremium;
        this.isModerator = isModerator;
    }
    
}
