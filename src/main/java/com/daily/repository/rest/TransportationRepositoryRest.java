package com.daily.repository.rest;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daily.domain.Transportation;

/*for spring data rest*/
@RepositoryRestResource(collectionResourceRel="transportation",path="transportationUrl")
public interface TransportationRepositoryRest extends MongoRepository<Transportation, String> {
}
