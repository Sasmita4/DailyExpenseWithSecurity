package com.daily.config;

import org.mongeez.Mongeez;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

@Configuration
@EnableMongoRepositories("com.daily.repository")
@Import(value = MongoAutoConfiguration.class)
@RefreshScope
public class MongoDBConfiguration extends AbstractMongoConfiguration{
	
	Logger log = LoggerFactory.getLogger(MongoDBConfiguration.class);
	
	@Autowired
	private Mongo mongo;

	@Override
	public Mongo mongo() throws Exception {
		return mongo;
	}

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private String mongoPort;

    @Value("${spring.data.mongodb.database}")
    private String mongoDB;

    @Override
    public MongoMappingContext mongoMappingContext()
        throws ClassNotFoundException {
        return super.mongoMappingContext();
    }
   
    @Override
    protected String getDatabaseName() {
        return mongoDB;
    }
    @Bean
    public Mongeez mongeez() {
    	Mongeez mongeez = new Mongeez();
    	mongeez.setMongo(mongo);
    	mongeez.setFile(new ClassPathResource("/mongeez/master.xml"));
    	mongeez.setDbName(mongoDB);
    	mongeez.process();
    	return mongeez;
    }
}
