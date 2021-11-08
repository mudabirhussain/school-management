package javabrain.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import javabrain.pma.entities.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long>
{
	List<Subject> findAll();
}
