package messagingstompwebsocket.Service;

import messagingstompwebsocket.Models.Users;
import messagingstompwebsocket.Repos.UserRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users save(Users users){
        return userRepository.save(users);
    }

    public Users findById(Integer id){
        return userRepository.findById(id).get();
    }
}
