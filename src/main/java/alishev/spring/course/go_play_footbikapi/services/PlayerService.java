package alishev.spring.course.go_play_footbikapi.services;

import alishev.spring.course.go_play_footbikapi.models.Player;
import alishev.spring.course.go_play_footbikapi.repositories.PlayerRepository;
import alishev.spring.course.go_play_footbikapi.security.dao.PlayerDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService implements UserDetailsService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Player> player = playerRepository.findPlayerByUserName(username);
        if(player.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return new PlayerDao(player.get());
    }

}
