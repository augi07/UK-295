package ch.csbe.productstore.controller;

import ch.csbe.productstore.dto.user.*;
import ch.csbe.productstore.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Login & Registrierung")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public TokenWrapper login(@RequestBody @Valid LoginRequestDto dto) {
        return authService.login(dto);
    }

    @PostMapping("/register")
    public UserShowDto register(@RequestBody @Valid UserCreateDto dto) {
        return authService.register(dto);
    }
}
