package com.helmes.cities.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.helmes.cities.adapter.out")
public class MongoDbConfig {

}
