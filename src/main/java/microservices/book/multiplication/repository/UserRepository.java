package microservices.book.multiplication.repository;

import microservices.book.multiplication.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 *  This interface allows us to save and retrieve Users
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     *
     * @param alias
     * @return optional of user find by alias
     */
    Optional<User> findByAlias(String alias);

}
