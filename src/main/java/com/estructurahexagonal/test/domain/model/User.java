package com.estructurahexagonal.test.domain.model;

public record User(
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
    
}
