package com.herwaarden.osrsmate.resources;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/public/test")
public class TestResource {

    int value = 0;

    @CrossOrigin(origins = {"*"})
    @GetMapping(value = "/getTestId/{id}")
    String GetTestId(@PathVariable("id")int id){
        return "Test probably works. Your id is = " + id;
    }

    @CrossOrigin(origins = {"*"})
    @GetMapping(value = "/getTestValue/")
    String GetTestValue(){
        return "Value = " + value;
    }

    @CrossOrigin(origins = {"*"})
    @PutMapping(value = "/putTestValue/{id}")
    String PutTestValue(@PathVariable("id")int id){
        value = id;
        return "Value is updated to " + value;
    }
}
