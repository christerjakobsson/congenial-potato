package com.example.demo.Repositories;

import com.example.demo.Models.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class SessionRepository extends EntityBaseRepository<Session> {

    @Autowired
    public SessionRepository(MongoTemplate template) {
    }


    public Session findByUserId(UUID id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(id)).limit(1);
        return findByQuery(query);
    }
}

