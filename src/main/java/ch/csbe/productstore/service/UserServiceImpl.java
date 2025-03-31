package ch.csbe.productstore.service;

import ch.csbe.productstore.entity.User;
import ch.csbe.productstore.exception.ResourceNotFoundException;
import ch.csbe.productstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Override
    public void promoteToAdmin(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.getRoles().add("ADMIN");
        userRepo.save(user);
    }
}
