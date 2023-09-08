package com.tui.tech.interview.quotegarden.controller;


import com.tui.tech.interview.quotegarden.model.Quote;
import com.tui.tech.interview.quotegarden.service.IQuoteGardenService;
import com.tui.tech.interview.quotegarden.utils.Links;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class QuoteGardenController {

    @Autowired
    IQuoteGardenService service;

    @GetMapping(
            path = Links.PATH_ITEMS,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Flux<Quote>> getAllItem(){
        return ResponseEntity.ok(service.searchAllItem());
    }

    @GetMapping(
            path = Links.PATH_ITEMS_BY_ID,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Mono<Quote>> getItemById(@RequestParam(name = "id") String id){
        return ResponseEntity.ok(service.searchItemById(id));
    }
}
