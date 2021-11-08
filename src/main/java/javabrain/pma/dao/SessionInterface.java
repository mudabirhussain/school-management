package javabrain.pma.dao;

import org.springframework.data.repository.CrudRepository;

import javabrain.pma.entities.Session;

public interface SessionInterface extends CrudRepository<Session, Long> {

}
