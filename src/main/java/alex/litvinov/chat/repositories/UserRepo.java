package alex.litvinov.chat.repositories;

import alex.litvinov.chat.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByLogin(String login);
}
