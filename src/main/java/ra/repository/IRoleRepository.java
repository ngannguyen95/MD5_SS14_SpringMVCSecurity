package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.model.Role;
import ra.model.RoleName;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role,Long> {
Optional<Role> findByName(RoleName name);
}
