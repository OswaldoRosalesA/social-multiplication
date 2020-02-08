package microservices.book.multiplication.service;

import lombok.AllArgsConstructor;
import microservices.book.multiplication.domain.Multiplication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MultiplicationServiceImpl implements MultiplicationService {

    private RandomGeneratorService randomGeneratorService;

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

}

