package com.tui.tech.interview.quotegarden.repository;

import com.tui.tech.interview.quotegarden.model.Quote;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface QuoteRepository extends ReactiveCrudRepository<Quote, String> {
    Flux<Quote> findAllByQuoteAuthor(String author);
    Mono<Quote> findBy_idAndQuoteAuthor(String _id, String quoteAuthor);
    Mono<Quote> findBy_id(String _id);
}
