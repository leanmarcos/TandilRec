package com.tandilrec.TandilRec;

import jakarta.websocket.OnError;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
public class TandilRecApplication {

	public static void main(String[] args) {
		SpringApplication.run(TandilRecApplication.class, args);
	}

}
