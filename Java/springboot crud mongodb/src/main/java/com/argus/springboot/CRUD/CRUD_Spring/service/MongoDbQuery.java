/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.CRUD_Spring.service;

import com.argus.springboot.CRUD.CRUD_Spring.files.Student;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nihar
 */

@Repository
public class MongoDbQuery {
    
    private final MongoTemplate mongoTemplate ;
    @Autowired(required = true)
    private  MongoTemplate mongoTemplate1 ;
     
     @Autowired(required = true)
    public MongoDbQuery(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    
    
   
//    MongoOperations mongoOperation = 
//                         (MongoOperations) ctx.getBean("mongoTemplate");
//    BasicQuery query1 = new BasicQuery("{ mobile : { $lt : 974319510 }, name : 'nihar' }");
//    User userTest1 = mongoOperation.findOne(query1, User.class);
    
     public Student findOneByFirstName(String name) {
          Query query = new Query();
           query.addCriteria(Criteria.where("firstName").is(name));
          
           return mongoTemplate.findOne(query, Student.class);
        }
     
      public List<Student>  findAllByFirstName(String name) {
          Query query = new Query();
           query.addCriteria(Criteria.where("firstName").is(name));
         // mongoTemplate1.insert(name, name);
           return mongoTemplate.find(query,Student.class);
        }
 
}
