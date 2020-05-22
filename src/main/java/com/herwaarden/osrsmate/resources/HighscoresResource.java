package com.herwaarden.osrsmate.resources;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/public/highscores")
public class HighscoresResource {

    @CrossOrigin(origins = {"*"})
    @GetMapping(value = "/getUserByUsername/{username}")
    String getUserByUsername(@PathVariable("username")String username){
        return "Yeet";
    }
}
