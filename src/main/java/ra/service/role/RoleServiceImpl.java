package ra.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.Role;
import ra.model.RoleName;
import ra.repository.IRoleRepository;
import ra.service.role.IRoleService;

import java.util.Optional;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository repository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return repository.findByName(name);
    }
}
