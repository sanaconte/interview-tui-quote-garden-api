package com.tui.tech.interview.quotegarden.service;

import com.tui.tech.interview.quotegarden.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class QuoteTemplateOperations {

    @Autowired
    ReactiveMongoTemplate template;

    public Mono<Quote> findById(String id) {
        return template.findById(id, Quote.class);
    }

    public Flux<Quote> findAll() {
        return template.findAll(Quote.class);
    }
    public Mono<Quote> save(Mono<Quote> account) {
        return template.save(account);
    }
}
