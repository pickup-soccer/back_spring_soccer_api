package alishev.spring.course.go_play_footbikapi.models;

import alishev.spring.course.go_play_footbikapi.models.base_model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Role extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Set<Player> players;
}
