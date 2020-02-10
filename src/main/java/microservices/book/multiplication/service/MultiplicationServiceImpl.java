package microservices.book.multiplication.service;

import lombok.AllArgsConstructor;
import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.domain.User;
import microservices.book.multiplication.repository.MultiplicationRepository;
import microservices.book.multiplication.repository.MultiplicationResultAttemptRepository;
import microservices.book.multiplication.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
@AllArgsConstructor
class MultiplicationServiceImpl implements MultiplicationService {

    private RandomGeneratorService randomGeneratorService;
    private MultiplicationResultAttemptRepository attemptRepository;
    private UserRepository userRepository;
    private MultiplicationRepository multiplicationRepository;

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Transactional
    @Override
    public boolean checkAttempt(MultiplicationResultAttempt resultAttempt) {
        // Avoids 'hack' attempts
        Assert.isTrue(!resultAttempt.isCorrect(), "You can't send an attempt marked as correct!!");

        // Checks if the user already exists for that alias
        Optional<User> user = userRepository.findByAlias(resultAttempt.getUser().getAlias());

        // check if the multiplication already exists for those factors
        Optional<Multiplication> multiplication = multiplicationRepository.findByFactorAAndAndFactorB(
                resultAttempt.getMultiplication().getFactorA(),
                resultAttempt.getMultiplication().getFactorB());

        // Checks if it's correct
        boolean correct = resultAttempt.getResultAttempt() ==
                resultAttempt.getMultiplication().getFactorA() *
                        resultAttempt.getMultiplication().getFactorB();

        // Creates a copy, now setting the 'correct' field accordingly
        MultiplicationResultAttempt checkedAttempt =
                new MultiplicationResultAttempt(resultAttempt.getResultAttempt(),
                        correct,
                        user.orElse(resultAttempt.getUser()),
                        multiplication.orElse(resultAttempt.getMultiplication()));

        // Store the attempt
        attemptRepository.save(checkedAttempt);

        // Returns the result
        return correct;
    }

}

