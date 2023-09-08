package com.tui.tech.interview.quotegarden.repository;


import com.tui.tech.interview.quotegarden.QuotegardenApplication;
import com.tui.tech.interview.quotegarden.configuration.MongoReactiveConfig;
import com.tui.tech.interview.quotegarden.model.Quote;
import com.tui.tech.interview.quotegarden.service.QuoteTemplateOperations;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = QuotegardenApplication.class)
public class QuoteRepositoryTest {

    @Autowired
    QuoteRepository repository;

    @Autowired
    QuoteTemplateOperations quoteTemplateOperations;


    @Test
    public void shouldFindByAuthor() {

        Quote q1 = repository.save(new Quote("1", "QuoteText", "SANA", "quoteGenre", 0)).block();
        Quote q2 = repository.save(new Quote("2", "QuoteText", "SANA", "quoteGenre", 0)).block();
        Quote q3 = repository.save(new Quote("3", "QuoteText", "SANA", "quoteGenre", 0)).block();

        Flux<Quote> accountFlux = repository.findAllByQuoteAuthor("SANA");

        StepVerifier
                .create(accountFlux)
                .expectNextCount(3)
                .expectComplete()
                .verify();

        // remove data after test completion
        repository.delete(q1).block();
        repository.delete(q2).block();
        repository.delete(q3).block();
    }



    @Test
    public void shouldFindAllByIdAndAuthor() {


        Quote q1 = repository.save(new Quote("2", "QuoteText", "SANA", "quoteGenre", 0)).block();
        Mono<Quote> quoteFlux = repository.findBy_idAndQuoteAuthor("2", "SANA");

        StepVerifier
                .create(quoteFlux)
                .assertNext(quote -> {
                    assertEquals("2", quote.get_id());
                    assertEquals("SANA", quote.getQuoteAuthor());
                })
                .expectComplete()
                .verify();

        // remove data after test completion
        repository.delete(q1).block();
    }



    @Test
    public void shouldFindById() {

        //Quote quote1 = repository.save(new Quote("qwerty", "quoteText", "SANANA", "quoteGenre", 0)).block();

        Mono<Quote> accountMono = repository.findById("5eb17aadb69dc744b4e70d4a");


        StepVerifier
                .create(accountMono)
                .assertNext(quote -> {
                    assertEquals("5eb17aadb69dc744b4e70d4a", quote.get_id());
                    //assertEquals(Double.valueOf(12.3) , account.getValue());
                    //assertNotNull(account.getId());
                })
                .expectComplete()
                .verify();

        // remove data after test completion
        //repository.delete(quote1).block();

    }



}
