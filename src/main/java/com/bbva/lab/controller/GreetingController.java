package com.bbva.lab.controller;

import com.bbva.lab.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by jorge on 17/04/2017.
 */

@RestController
public class GreetingController {

    private static final String template = "Hello, %s! From %s (IP: %s)";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello/{name}")
    public Greeting greeting(@PathVariable String name) throws UnknownHostException {
        String hostname = InetAddress.getLocalHost().getHostName();
        String ipAddress = InetAddress.getLocalHost().getHostAddress();
        return new Greeting(counter.incrementAndGet(),String.format(template,name, hostname, ipAddress));
    }

}
