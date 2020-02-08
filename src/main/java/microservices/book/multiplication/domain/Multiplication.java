package microservices.book.multiplication.domain;

import lombok.*;

/**
 * This represents a Multiplication (a * b).
 */
@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public final class Multiplication {

    private final int factorA;
    private final int factorB;

    Multiplication(){
        this(0,0);
    }

}
