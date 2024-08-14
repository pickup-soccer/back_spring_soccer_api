package alishev.spring.course.go_play_footbikapi.controllers;

import alishev.spring.course.go_play_footbikapi.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final PlayerService playerService;

    @GetMapping("/hello_dulik")
    public String get() {
        return "A DULA DUT LUBIT VOT ON I DUET";
    }

}
