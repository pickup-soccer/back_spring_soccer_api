package alishev.spring.course.go_play_footbikapi.repositories;

import alishev.spring.course.go_play_footbikapi.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findPlayerByUserName(String username);

}
