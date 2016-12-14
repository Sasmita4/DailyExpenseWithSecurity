package com.daily.config;

import org.mongeez.Mongeez;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

@Configuration
@EnableMongoRepositories("com.daily.repository")
@Import(value = MongoAutoConfiguration.class)
public class MongoDBConfiguration extends AbstractMongoConfiguration{
	
	@Autowired
	private Environment env; 
	
	@Autowired
	private Mongo mongo;

	@Autowired
	private MongoProperties mongoProperties;
	
	protected String getDatabaseName() {
		return mongoProperties.getDatabase();
	}

	@Override
	public Mongo mongo() throws Exception {
		return mongo;
	}
	@Bean
    public Mongeez mongeez() {
        Mongeez mongeez = new Mongeez();
        mongeez.setMongo(mongo);
        mongeez.setFile(new ClassPathResource("/mongeez/master.xml"));
        mongeez.setDbName(mongoProperties.getDatabase());
		mongeez.process();
        return mongeez;
    }

}
