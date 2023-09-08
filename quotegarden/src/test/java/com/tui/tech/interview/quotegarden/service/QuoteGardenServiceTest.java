package com.tui.tech.interview.quotegarden.service;


import com.tui.tech.interview.quotegarden.repository.QuoteRepository;
import com.tui.tech.interview.quotegarden.response.Pagination;
import com.tui.tech.interview.quotegarden.model.Quote;
import com.tui.tech.interview.quotegarden.response.QuoteData;
import com.tui.tech.interview.quotegarden.response.QuoteGardenResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;


@SpringBootTest
public class QuoteGardenServiceTest {

    @Autowired
    private QuoteGardenService service;

    @Autowired
    private QuoteRepository repository;

    @Autowired
    private WebClient webClient;

    @Test
    void saveData(){

        QuoteGardenResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/quotes")
                        .queryParam("limit", "5")
                        .build())
                .retrieve()
                .bodyToMono(QuoteGardenResponse.class).block();

        repository.saveAll(response.getData().stream().map(qd->toQuote(qd))
                .collect(Collectors.toList())).toIterable()
                .forEach(quote -> System.out.println(quote));

    }

    private Quote toQuote(QuoteData quoteData) {
        return new Quote(
                quoteData.get_id(),
                quoteData.getQuoteText(),
                quoteData.getQuoteAuthor(),
                quoteData.getQuoteGenre(),
                quoteData.get__v());
    }

    @Test
    void givenId_whenGetItemById_thenReturnItem() {



        String author = "Bill Gates";
        String id = "5eb17aaeb69dc744b4e73683";

        Mono<Quote> response = service.searchItemById(id);


        StepVerifier
                .create(response)
                .expectNextCount(1).verifyComplete();
//                .consumeNextWith(r -> {
//                    Assertions.assertEquals("5eb17aaeb69dc744b4e73683", r.get_id());
//                }).verifyComplete();


    }
}
