package com.tui.tech.interview.quotegarden;

import com.tui.tech.interview.quotegarden.model.Quote;
import com.tui.tech.interview.quotegarden.repository.QuoteRepository;
import com.tui.tech.interview.quotegarden.response.QuoteData;
import com.tui.tech.interview.quotegarden.response.QuoteGardenResponse;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class StartRunner implements ApplicationRunner {

 //Add whatever Bean you need here and autowire them through the constructor or with @Autowired

    @Autowired
    QuoteRepository repository;

    @Autowired
    private WebClient webClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Long count = repository.findAll().count().block();
        if(count == 0) {
            System.out.println("Database population started.");
            Stream.iterate(1, i -> i + 1).takeWhile(i -> i < 148).forEach(i -> {
                String atualPage = i+"";
                QuoteGardenResponse response = webClient.get()
                        .uri(uriBuilder -> uriBuilder
                                .path("/quotes")
                                .queryParam("limit", "500")
                                .queryParam("page", atualPage)
                                .build())
                        .retrieve()
                        .bodyToMono(QuoteGardenResponse.class).block();

                repository
                        .saveAll(response.getData().stream().map(qd -> toQuote(qd))
                        .collect(Collectors.toList())).toIterable()
                        .forEach(quote -> System.out.println(quote));

            });
            System.out.println("Database populated.");
        }
        else {
            System.out.println("Database is already populated.");
        }

    }

    private Quote toQuote(QuoteData quoteData) {
        return new Quote(
                quoteData.get_id(),
                quoteData.getQuoteText(),
                quoteData.getQuoteAuthor(),
                quoteData.getQuoteGenre(),
                quoteData.get__v());
    }
}

