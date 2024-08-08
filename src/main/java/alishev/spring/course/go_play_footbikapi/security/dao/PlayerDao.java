package alishev.spring.course.go_play_footbikapi.security.dao;

import alishev.spring.course.go_play_footbikapi.models.Player;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class PlayerDao implements UserDetails {

    private final Player player;

    public PlayerDao(Player player) {
        this.player = player;
    }

    @Override
    public String getUsername() {
        return player.getUserName();
    }

    @Override
    public String getPassword() {
        return player.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }
    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }
}
