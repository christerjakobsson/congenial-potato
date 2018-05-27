package hello.Repositories;

import hello.Models.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.UUID;

public class SessionRepositoryImpl implements SessionRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Session findByUserId(UUID id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(id)).limit(1);
        return mongoTemplate.findOne(query, Session.class);
    }
}

