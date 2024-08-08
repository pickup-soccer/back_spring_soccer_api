package alishev.spring.course.go_play_footbikapi.models;

import alishev.spring.course.go_play_footbikapi.models.base_model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
}
