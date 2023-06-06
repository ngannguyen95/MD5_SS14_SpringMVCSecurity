package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.model.User;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Long> {
    // check username khong trung lap
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
    // tim kiem username co ton tai trong db hay khong
    Optional<User> findByUserName(String username);


}
