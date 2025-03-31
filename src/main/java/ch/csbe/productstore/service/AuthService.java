package ch.csbe.productstore.service;

import ch.csbe.productstore.dto.user.*;
import ch.csbe.productstore.entity.User;

public interface AuthService {
    TokenWrapper login(LoginRequestDto dto);
    UserShowDto register(UserCreateDto dto);
}
