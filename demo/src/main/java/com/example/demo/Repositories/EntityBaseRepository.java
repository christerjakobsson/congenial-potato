package com.example.demo.Repositories;

import com.example.demo.Models.EntityBase;
import com.example.demo.Models.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class EntityBaseRepository<T extends EntityBase> {

    private final MongoTemplate mongoTemplate;

    @Resource
    private final String collectionName;

    private Class<T> clazz;

    @Autowired
    public EntityBaseRepository(MongoTemplate mongoTemplate, /* String collectionName) {
        this.mongoTemplate = mongoTemplate;
        this.collectionName = collectionName;
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    public T save (T entity, Session session) {
        entity.setModifiedAt(Date.from(Instant.now()));

        entity.setModifiedById(session.getUserId());
        if(entity.getId() == null) {
            entity.setId(UUID.randomUUID());
            mongoTemplate.insert(entity, collectionName);

        } else {
            mongoTemplate.save(entity, collectionName);
        }

        return entity;
    }

    public T find(UUID id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, clazz, collectionName);
    }

    public List<T> findAll(int pageIndex, int pageSize) {
        Query query = new Query();
        query.skip(pageSize * pageIndex).limit(pageSize);
        return mongoTemplate.find(query, clazz, collectionName);
    }

    public T findByQuery(Query query) {
        return mongoTemplate.findOne(query, clazz, collectionName);
    }

    public void deleteAll() {
        mongoTemplate.remove(new Query(), collectionName);
    }
}