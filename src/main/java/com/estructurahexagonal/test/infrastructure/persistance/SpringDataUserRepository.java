package com.estructurahexagonal.test.infrastructure.persistance;

import com.azure.spring.data.cosmos.repository.CosmosRepository;

public interface SpringDataUserRepository extends CosmosRepository<UserEntity, String>{
    
}
