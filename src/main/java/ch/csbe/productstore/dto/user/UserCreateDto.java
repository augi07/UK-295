package ch.csbe.productstore.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserCreateDto {
    @NotNull
    private String email;

    @NotNull
    private String password;
}