package ch.csbe.productstore.service;

import ch.csbe.productstore.dto.user.*;
import ch.csbe.productstore.entity.User;
import ch.csbe.productstore.exception.InvalidCredentialsException;
import ch.csbe.productstore.mapper.UserMapper;
import ch.csbe.productstore.repository.UserRepository;
import ch.csbe.productstore.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepo;
    private final UserMapper userMapper;
    private final TokenService tokenService;
    private final BCryptPasswordEncoder passwordEncoder; // 👈 hinzugefügt

    @Override
    public TokenWrapper login(LoginRequestDto dto) {
        User user = userRepo.findByEmail(dto.getEmail())
                .orElseThrow(InvalidCredentialsException::new);

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        String token = tokenService.generateToken(user);
        return new TokenWrapper(token);
    }

    @Override
    public UserShowDto register(UserCreateDto dto) {
        User user = User.builder()
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword())) // 👈 jetzt mit Bean
                .roles(Set.of("USER"))
                .build();

        User saved = userRepo.save(user);

        UserShowDto result = new UserShowDto();
        result.setId(saved.getId());
        result.setEmail(saved.getEmail());
        result.setRoles(saved.getRoles());
        return result;
    }
}