package alishev.spring.course.go_play_footbikapi.controllers;

import alishev.spring.course.go_play_footbikapi.security.dao.PlayerDao;
import alishev.spring.course.go_play_footbikapi.security.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @PostMapping("/login")
    public ResponseEntity<?> login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PlayerDao playerDao = (PlayerDao) authentication.getPrincipal();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(playerDao.getUsername(), playerDao.getPassword())
        );
        if(authentication.isAuthenticated()) {
            Map<String, Object> claims = new HashMap<>();
            return new ResponseEntity<>(
                    jwtService.generateToken(claims, playerDao.getUsername()), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}
