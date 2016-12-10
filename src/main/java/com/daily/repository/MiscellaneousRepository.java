package com.daily.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.daily.domain.Miscellaneous;

public interface MiscellaneousRepository  extends MongoRepository<Miscellaneous, String>{

}
