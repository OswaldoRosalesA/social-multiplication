package microservices.book.multiplication.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorServiceImplTest {

    private RandomGeneratorServiceImpl randomGeneratorService;

    @BeforeEach
    public void setUp() {
        randomGeneratorService = new RandomGeneratorServiceImpl();
    }

    @Test
    public void generateRandomFactorIsBetweenExpectedLimits() {
        // when a good sample of randomly generated factors is generated
        List<Integer> randomFactors = IntStream.range(0, 1000)
                .map(i -> randomGeneratorService.generateRandomFactor())
                .boxed()
                .collect(Collectors.toList());
        // then all of them should be between 11 and 100
        // because we want a middle-complexity calculation
        assertThat(randomFactors).containsOnlyElementsOf(IntStream.range(11, 100)
                .boxed()
                .collect(Collectors.toList()));
    }

}