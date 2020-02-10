package microservices.book.multiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Identifies the attempt from a {@link User} to solve a
 * {@link Multiplication} .
 */
@Entity
@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Table(name = "MULTIPLICATION_RESULT_ATTEMPT", schema = "SOCIAL_MULTIPLICATION")
public final class MultiplicationResultAttempt {

    @Id
    @GeneratedValue
    @Column(name = "MULTIPLICATION_RESULT_ATTEMPT_ID")
    private Long id;

    @NotNull
    @Column(name = "RESULT_ATTEMPT", nullable = false)
    private final int resultAttempt;

    @NotNull
    @Column(name = "CORRECT", nullable = false)
    private final boolean correct;

    @JoinColumn(name = "USER_ID")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private final User user;

    @JoinColumn(name = "MULTIPLICATION_ID")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private final Multiplication multiplication;

    // Empty constructor for JSON (de)serialization
    MultiplicationResultAttempt() {
        user = null;
        multiplication = null;
        resultAttempt = -1;
        correct = false;
    }

}
