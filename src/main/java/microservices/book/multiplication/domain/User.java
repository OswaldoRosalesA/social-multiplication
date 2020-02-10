package microservices.book.multiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Stores information to identify the user.
 */
@Entity
@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Table(name = "USER", schema = "SOCIAL_MULTIPLICATION")
public final class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @NotNull
    @Column(name = "ALIAS", nullable = false)
    private final String alias;

    // Empty constructor for JSON (de)serialization
    protected User() {
        alias = null;
    }
}
