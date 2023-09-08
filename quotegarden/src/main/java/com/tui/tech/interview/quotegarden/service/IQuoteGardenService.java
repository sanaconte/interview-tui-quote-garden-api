package com.tui.tech.interview.quotegarden.service;

import com.tui.tech.interview.quotegarden.model.Quote;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IQuoteGardenService {

    Flux<Quote> searchAllItem();
    Mono<Quote> searchItemById(String id);
}
