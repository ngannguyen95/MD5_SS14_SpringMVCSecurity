package ra.service.role;

import ra.model.Role;
import ra.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
