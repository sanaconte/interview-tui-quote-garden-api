package com.tui.tech.interview.quotegarden.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.convert.NoOpDbRefResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.tui.tech.interview.quotegarden.repository")
public class MongoReactiveConfig  extends AbstractReactiveMongoConfiguration {
    @Bean
    public MongoClient mongoClient() {
        //return MongoClients.create("mongodb://localhost:27017/quote-arden-db");
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return "quote-garden-db";
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDatabaseFactory databaseFactory, MappingMongoConverter converter) {
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return new MongoTemplate(databaseFactory, converter);
    }
//
//    private List<Converter<?,?>> converters = new ArrayList<Converter<?,?>>();
//
//    @Override
//    public MongoCustomConversions customConversions() {
//        converters.add(new QuoteConverter());
//        return new MongoCustomConversions(converters);
//
//    }

//    @Bean
//    public ReactiveMongoTemplate reactiveMongoTemplate() {
//        ReactiveMongoTemplate template = new ReactiveMongoTemplate(mongoClient(), getDatabaseName());
//        MappingMongoConverter converter = (MappingMongoConverter) template.getConverter();
//        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//        converter.afterPropertiesSet();
//        return template;
//    }
}
