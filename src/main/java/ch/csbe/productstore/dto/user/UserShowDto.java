package ch.csbe.productstore.dto.user;

import lombok.Data;

import java.util.Set;

@Data
public class UserShowDto {
    private Long id;
    private String email;
    private Set<String> roles;
}
