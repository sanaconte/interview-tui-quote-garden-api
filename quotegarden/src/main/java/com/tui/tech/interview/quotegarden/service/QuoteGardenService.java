package com.tui.tech.interview.quotegarden.service;

import com.tui.tech.interview.quotegarden.model.Quote;
import com.tui.tech.interview.quotegarden.repository.QuoteRepository;
import com.tui.tech.interview.quotegarden.response.QuoteGardenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class QuoteGardenService implements IQuoteGardenService{

    @Autowired
    QuoteRepository repository;

    @Override
    public Flux<Quote> searchAllItem() {
        return repository.findAll();
    }

    @Override
    public Mono<Quote> searchItemById(String id) {
        return repository.findById(id);
    }
}
