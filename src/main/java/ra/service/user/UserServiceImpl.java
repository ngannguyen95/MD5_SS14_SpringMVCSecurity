package ra.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.User;
import ra.repository.IUserRepository;

import java.util.Optional;
@Service
public class UserServiceImpl implements IUserService{
   @Autowired
    IUserRepository userRepository;
    @Override
    public Boolean existsByUserName(String username) {
        return userRepository.existsByUserName(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Optional<User> findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
