package alishev.spring.course.go_play_footbikapi.controllers;

import alishev.spring.course.go_play_footbikapi.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final PlayerService playerService;

    @CrossOrigin(origins = "http://localhost:8000")
    @PostMapping("/login")
    public ResponseEntity<?> login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(authentication.getPrincipal(), HttpStatus.OK);
    }

    @GetMapping("/get_all_players")
    public ResponseEntity<?> getAllPlayers() {
        return new ResponseEntity<>(playerService.findAll(), HttpStatus.OK);
    }

}
