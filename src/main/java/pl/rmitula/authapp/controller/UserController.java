package pl.rmitula.authapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.rmitula.authapp.dto.UserSummary;
import pl.rmitula.authapp.security.CurrentUser;
import pl.rmitula.authapp.security.UserPrincipal;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
    }

}
