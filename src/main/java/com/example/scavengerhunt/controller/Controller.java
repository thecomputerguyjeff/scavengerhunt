package com.example.scavengerhunt.controller;

import com.example.scavengerhunt.model.SingleKeyValue;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class Controller {

//    @GetMapping("/start")
//    public String start() {
//        return "Awesome! You've made it in! Welcome :) \nMake a GET request to /next to continue";
//    }

    @GetMapping("/start")
    public String start() {
        return "You are early...try again later";
    }

    @GetMapping("/next")
    public String next() {
        return "Allright, getting serious. We're gonna learn some fun things about APIs today!. Make a GET request to /echo/fun to continue";
    }

    @GetMapping("/echo/{echoField}")
    public String echo (@PathVariable String echoField) {
        if("done".equalsIgnoreCase(echoField)) {
            return "Awesome. That was fun fun fun (get it! Echo!). I can read in Path Variables from URLs and do whatever I want with them.\n" +
                    "Path variables are just one of many ways to send inputs into APIs. We'll continue to explore more" +
                    "\n...but first... lets talk about responses... Please make a GET request to /response";
        }
        return "This will echo whatever you tell it to!\n" +
                echoField + " " + echoField + " " + echoField +
                "\ntry it with a few different words. When you are done, echo done.";
    }

    @GetMapping("/response")
    public Object response(@RequestHeader String use) {
        if("json".equalsIgnoreCase(use)) {
            return SingleKeyValue.builder().key("This is a Json Object!").next("GET request to /json").build();
        }
        return "See what I did there... You've just learned about path variables! Aren't scavenger hunts fun! Honestly, I'm having way too much fun doing this...\n\n" +
                "anyways... so right now, all I have been responding to your APIs are STRING responses. They are boring and not very useful. A MUCH better way to respond\n" +
                "is with something call JSON. JSON is much more readable, and usable. Let's see what it looks like...\n" +
                "Please add a header to your request (also called a request header). The key should be 'use' and the value should be 'json'. Good luck!";
    }

    @GetMapping("/json")
    public String json(@RequestHeader String use) {
        if ("json".equalsIgnoreCase(use)) {
            return "Hey, I didn't tell you to use a header...please remove it!";
        }
        return "See how nice JSON is! JSON is always one giant OBJECT. Within that object, you can have key/value pairs, like you saw above.\n" +
                "values can be numbers (1 or 1.0), Strings, booleans (true/false). They can also be null, another object ( {} ) or an array ( []) " +
                "The can be 2 lines, or 1000s of lines long. They always start with { and end with } because they are one giant object" +
                "\nLet's see another example of a json object, make a GET request to /jsonRequest";
    }
}
