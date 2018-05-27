package com.example.demo.Repositories;

import com.example.demo.Models.Session;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SessionRepository extends MongoRepository<Session, UUID>, SessionRepositoryCustom {

    //other methods
}
