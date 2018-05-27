package com.example.demo.Repositories;

import com.example.demo.Models.Session;

import java.util.UUID;

public interface SessionRepositoryCustom {
    Session findByUserId(UUID id);
    /*
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(id)).limit(1);
        return findByQuery(query);
    }
    */
}
