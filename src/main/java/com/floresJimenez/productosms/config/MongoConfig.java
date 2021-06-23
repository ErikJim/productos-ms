package com.floresJimenez.productosms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.floresJimenez.productosms.repositories")
public class MongoConfig {
}
