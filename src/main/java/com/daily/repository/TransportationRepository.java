package com.daily.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.daily.domain.Transportation;

public interface TransportationRepository extends MongoRepository<Transportation, String> {

}
