package com.example.demo.Repositories;

import com.example.demo.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends EntityBaseRepository<User> {

    @Autowired
    public UserRepository(MongoTemplate mongoTemplate) {

    }

    public User findByEmail(String email) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        return super.findByQuery(query);
    }
}
