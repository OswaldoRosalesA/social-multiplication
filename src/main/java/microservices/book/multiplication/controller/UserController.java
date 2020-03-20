package microservices.book.multiplication.controller;

import lombok.RequiredArgsConstructor;
import microservices.book.multiplication.domain.User;
import microservices.book.multiplication.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping(path = "/{userId}")
    public User getUserForId(@NotNull @PathVariable("userId") final Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NullPointerException("User not found with id: " + userId));
    }

}
