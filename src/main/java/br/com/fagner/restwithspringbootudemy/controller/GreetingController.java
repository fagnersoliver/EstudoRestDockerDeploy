package br.com.fagner.restwithspringbootudemy.controller;

import br.com.fagner.restwithspringbootudemy.Greeting;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static  final String template = "Hello, %s!";

    private final AtomicLong counter =  new AtomicLong();

    /* Fazendo o get para exibir o rest*/
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name",defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }

}
