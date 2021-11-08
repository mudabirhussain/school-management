package javabrain.pma.dao;

import org.springframework.data.repository.CrudRepository;

import javabrain.pma.entities.Semester;

public interface SemesterInterface extends CrudRepository<Semester, Long> {

}
