package javabrain.pma;

import java.util.List;
import java.util.Vector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javabrain.pma.entities.Participant;
import javabrain.pma.entities.Subject;

@SpringBootApplication
public class ProjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

	
	@Bean
	public Participant getParticipantBean()
	{
		return new Participant();
	}
	@Bean
	public Subject getSubjectBean()
	{
		return new Subject();
	}
	
	@Bean
	public List<Participant> getParticipantList()
	{
		return new Vector<Participant>();
	}
}
