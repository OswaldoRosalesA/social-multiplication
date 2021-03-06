package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;

import java.util.List;

public interface MultiplicationService {

    /**
     * Generates a random {@link Multiplication} object.
     *
     * @return a multiplication of randomly generated numbers
     */
    Multiplication createRandomMultiplication();

    /**
     * @return true if the attempt matches the result of the
     *         multiplication, false otherwise.
     */
    MultiplicationResultAttempt checkAttempt(final MultiplicationResultAttempt resultAttempt);

    /**
     *
     * @param userAlias
     * @return at most last five attempts of the user by alias
     */
    List<MultiplicationResultAttempt> getStatsForUser(String userAlias);

    /**
     *
     * @param resultId
     * @return an attempt search by id
     */
    MultiplicationResultAttempt getResultById(Long resultId);

}
