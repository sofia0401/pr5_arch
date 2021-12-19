package messagingstompwebsocket.Repos;

import messagingstompwebsocket.Models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer> {
}
