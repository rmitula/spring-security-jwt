package pl.rmitula.authapp.service;

import org.springframework.stereotype.Service;
import pl.rmitula.authapp.dto.UserSummary;
import pl.rmitula.authapp.security.UserPrincipal;

@Service
public class UserService {

    public UserSummary getCurrentUser(UserPrincipal userPrincipal) {
        return UserSummary.builder()
                .id(userPrincipal.getId())
                .email(userPrincipal.getEmail())
                .name(userPrincipal.getName())
                .build();
    }
}
