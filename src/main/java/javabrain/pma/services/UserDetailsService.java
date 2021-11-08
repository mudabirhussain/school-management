package javabrain.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javabrain.pma.dao.ParticipantRepository;
import javabrain.pma.entities.Participant;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	ParticipantRepository partRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Participant participant = partRepo.getParticipantByUsername(username);
		if(participant == null)
		{
			throw new UsernameNotFoundException("Could Not Find Username");
		}
		
		return new MyUserDetails(participant);
	}

}
