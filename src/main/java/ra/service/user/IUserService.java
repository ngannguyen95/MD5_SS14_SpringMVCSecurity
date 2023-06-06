package ra.service.user;

import ra.model.User;

import java.util.Optional;

public interface IUserService {
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
    // tim kiem username co ton tai trong db hay khong
    Optional<User> findByUserName(String username);
    User save(User user);
}
