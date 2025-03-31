package ch.csbe.productstore.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequestDto {
    @NotNull
    private String email;

    @NotNull
    private String password;
}