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

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepo;
    private final UserMapper userMapper;
    private final TokenService tokenService;

    @Override
    public TokenWrapper login(LoginRequestDto dto) {
        User user = userRepo.findByEmail(dto.getEmail())
                .orElseThrow(() -> new InvalidCredentialsException());

        if (!new BCryptPasswordEncoder().matches(dto.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        String token = tokenService.generateToken(user);
        return new TokenWrapper(token);
    }

    @Override
    public UserShowDto register(UserCreateDto dto) {
        User user = userMapper.toEntity(dto);
        user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        user.setRoles(Collections.singleton("USER"));
        return userMapper.toShowDto(userRepo.save(user));
    }
}