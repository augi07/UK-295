package ch.csbe.productstore.controller;

import ch.csbe.productstore.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
@Tag(name = "User", description = "Benutzerrollen verwalten")
public class UserController {

    private final UserService userService;

    @PutMapping("/{id}")
    public void promoteToAdmin(@PathVariable Long id) {
        userService.promoteToAdmin(id);
    }
}
