package javabrain.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import javabrain.pma.entities.Participant;


public interface ParticipantRepository extends CrudRepository<Participant, Long> 
{
	Participant findByUsernameAndPassword(String username, String password);
	
	Participant getParticipantByUsername(String username);
	
	@Override
	List<Participant> findAll(); 
		
	//Iterable<Participant> findAllById(List<Integer> ids);
	
}
