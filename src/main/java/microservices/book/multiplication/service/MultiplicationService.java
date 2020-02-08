package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Multiplication;

public interface MultiplicationService {

    /**
     * Creates a multiplication with two randomly-generated factors
     *
     * @return a {@link Multiplication} object with two random factors
     */
    Multiplication createRandomMultiplication();

}
