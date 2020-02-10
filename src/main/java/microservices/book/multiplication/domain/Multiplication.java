package microservices.book.multiplication.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * This represents a Multiplication (a * b).
 */
@Entity
@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Table(name = "MULTIPLICATION", schema = "SOCIAL_MULTIPLICATION")
public final class Multiplication {

    @Id
    @GeneratedValue
    @Column(name = "MULTIPLICATION_ID")
    private Long id;

    @NotNull
    @Column(name = "FACTOR_A", nullable = false)
    private final int factorA;

    @NotNull
    @Column(name = "FACTOR_B", nullable = false)
    private final int factorB;

    Multiplication() {
        this(0, 0);
    }

}
