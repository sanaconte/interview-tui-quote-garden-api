package com.tui.tech.interview.quotegarden;

import com.tui.tech.interview.quotegarden.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuotegardenApplication {



	public static void main(String[] args) {
		SpringApplication.run(QuotegardenApplication.class, args);
	}

}
