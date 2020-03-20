package microservices.book.multiplication.service;

import lombok.RequiredArgsConstructor;
import microservices.book.multiplication.repository.MultiplicationRepository;
import microservices.book.multiplication.repository.MultiplicationResultAttemptRepository;
import microservices.book.multiplication.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final MultiplicationResultAttemptRepository multiplicationResultAttemptRepository;
    private final MultiplicationRepository multiplicationRepository;
    private final UserRepository userRepository;

    @Override
    public void deleteDatabaseContents() {
        multiplicationResultAttemptRepository.deleteAll();
        multiplicationRepository.deleteAll();
        userRepository.deleteAll();
    }
}
