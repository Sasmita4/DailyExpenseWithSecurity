package com.daily.repository.rest;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daily.domain.Miscellaneous;

@RepositoryRestResource(collectionResourceRel="miscellaneous",path="miscellaneousUrl")
public interface MiscellaneousRepositoryRest extends MongoRepository<Miscellaneous, String> {

}
