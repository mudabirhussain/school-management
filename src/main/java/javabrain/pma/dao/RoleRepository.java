package javabrain.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import javabrain.pma.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long>
{
	List<Role> findAll();
}
