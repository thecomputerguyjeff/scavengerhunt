package com.example.scavengerhunt.controller;

import com.example.scavengerhunt.model.BigJson;
import com.example.scavengerhunt.model.NestedObject;
import com.example.scavengerhunt.model.NumberObject;
import com.example.scavengerhunt.model.SingleKeyValue;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class Controller {

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
    public Object response(@RequestHeader(required=false) String use) {
        if("json".equalsIgnoreCase(use)) {
            return SingleKeyValue.builder().key("This is a Json Object!").next("GET request to /json").build();
        }
        return "See what I did there... You've just learned about path variables! Aren't scavenger hunts fun! Honestly, I'm having way too much fun doing this...\n\n" +
                "anyways... so right now, all I have been responding to your APIs are STRING responses. They are boring and not very useful. A MUCH better way to respond\n" +
                "is with something call JSON. JSON is much more readable, and usable. Let's see what it looks like...\n" +
                "Please add a header to your request (also called a request header) - using the headers tab. The key should be 'use' and the value should be 'json'. Good luck!";
    }

    @GetMapping("/json")
    public String json(@RequestHeader(required=false) String use) {
        if ("json".equalsIgnoreCase(use)) {
            return "Hey, I didn't tell you to use a header...please remove it!";
        }
        return "See how nice JSON is! JSON is always one giant OBJECT. Within that object, you can have key/value pairs, like you saw above.\n" +
                "values can be numbers (1 or 1.0), Strings, booleans (true/false). They can also be null, another object ( {} ) or an array ( []) " +
                "The can be 2 lines, or 1000s of lines long. They always start with { and end with } because they are one giant object" +
                "\nLet's see another example of a json object, make a GET request to /jsonRequest";
    }

    @GetMapping("/jsonRequest")
    public Object jsonRequest(@RequestParam(required = false) String done, @RequestParam(required = false) String second) {
        if("yes".equalsIgnoreCase(done)) {
            return "You just used a query param! Just like JSON, and headers, query params are also key value pairs. You can also have multiple query params, like this:\n" +
                    "try making a request to /jsonRequest?done=yes&second=hello";
        }
        if ("hello".equalsIgnoreCase(second)) {
            return "You did it! Great job! Extra / unknown query params will just be ignored, you can try putting a whole bunch in. When you are ready to move on, we are going to try something new!\n\n" +
                    "We are going to make a POST request. So far what we've seen with GET requests, you can input headers, path variables, and query params (as well as the actual url (or route) that you are calling.\n" +
                    "In response, you get response headers (which, truthfully we haven't really seen), and a response body.\n" +
                    "With a POST request, all of that is true, but you ALSO get a Request Body you can send into the API call. Let's try it. \n" +
                    "First click on GET, and change it to a POST. Set your route to /request. Find the body tab, and there are some radio buttons, you will want to select raw\n" +
                    "Then on the right, there is a dropdown where you will want to select JSON. Now you are ready to enter a body. to keep it simple. We will use a single key, key, and a value value.\n\n" +
                    "Don't forget to start with a { and end with a }. In between you will write \"key\": \"value\"\n\nLet's give it a shot!";
        }
        return BigJson.builder()
                .arrayOfObject(Arrays.asList(SingleKeyValue.builder().key("value1").build(),
                        SingleKeyValue.builder().key("value2").build()))
                .arrayOfStrings(Arrays.asList("This", "Is", "An", "Array", "Of", "Strings"))
                .nestedObject(NestedObject.builder()
                        .nestedKeyValue(SingleKeyValue.builder().key("nested value").build())
                        .build())
                .nestedObjectArray(Collections.singletonList(NestedObject.builder()
                        .nestedKeyValue(SingleKeyValue.builder().key("nested value").build())
                        .build()))
                .objectOfNumbers(NumberObject.builder().decimal(2.3).integer(4).build())
                .description("Take a look around. One thing that is interesting, I have NO I(DEA what order" +
                        "everything will be loaded in. JSON Objects, order does not matter(unless inside an array)\n" +
                        "and so this could be the first thing, or the last thing, or something else in the object.\n" +
                        "Once you are comfortable and feel like you understand what is going on, we're going to make" +
                        "a GET request to /jsonRequest?done=yes")
                .build();
    }

    @PostMapping("/request")
    public String request(@RequestBody SingleKeyValue singleKeyValue) {
        if ("value".equalsIgnoreCase(singleKeyValue.getKey())) {
            return "Awesome! You did it!\n I hope you enjoyed this little activity, and hope you learned something from it.\n" +
                    "The last thing to do is to open up github and see how this works. You will want to look in the model package \n" +
                    "To see the POJO's (look up what that stands for if you don't know) that represent all the JSON objects\n" +
                    "And look in the controller to see how all the endpoints are being used. Don't worry, I will be sure to explain it all next week in class!" +
                    "\nDon't forget to fill out the little quiz in canvas when you are done!\n\n" +
                    "github link: https://github.com/thecomputerguyjeff/scavengerhunt/tree/master/src/main/java/com/example/scavengerhunt" + "" +
                    "\n\n and the 'prize' at the end of the scavenger hunt is.... API Mastery! :)";
        }
        else {
            return "That didn't quite work... key was" + singleKeyValue.getKey();
        }
    }
}
