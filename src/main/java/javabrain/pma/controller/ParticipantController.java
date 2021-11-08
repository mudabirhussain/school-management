package javabrain.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javabrain.pma.dao.ParticipantRepository;
import javabrain.pma.dao.RoleRepository;
import javabrain.pma.dao.SubjectRepository;
import javabrain.pma.entities.Participant;
import javabrain.pma.entities.Role;

@RequestMapping("/participants")
@Controller
public class ParticipantController 
{
	@Autowired
	Participant participant;
	
	@Autowired
	ParticipantRepository repo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	SubjectRepository subRepo;
	
	@GetMapping
	public String showParticipants(Model model)
	{
		List<Participant> participants = repo.findAll();
		List<Role> roles = roleRepo.findAll();

		model.addAttribute("participants", participants);
		model.addAttribute("roles",roles);
		
		return "participants/participants";
	}
	
	
	@GetMapping("/add")
	public String addParticipant(Model model)
	{
		List<Role> roles = roleRepo.findAll();
		model.addAttribute("roles",roles);
		model.addAttribute("participant", participant);
		return "participants/add-participant";
	}
	
	@PostMapping("/save")
	public String saveParticipant(Participant participant)
	{
		repo.save(participant);	
		return "redirect:/participants";
	}
	
}
