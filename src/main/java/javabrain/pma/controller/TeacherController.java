package javabrain.pma.controller;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javabrain.pma.dao.ParticipantRepository;
import javabrain.pma.dao.RoleRepository;
import javabrain.pma.entities.Participant;
import javabrain.pma.entities.Role;

@RequestMapping("/teacher")
@Controller
public class TeacherController {
	
	@Autowired
	ParticipantRepository partRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@GetMapping
	public String showTeachers(Model model)
	{
		List<Participant> teachers = new Vector<Participant>();
		
		List<Participant> participants = partRepo.findAll();
		List<Role> roles = roleRepo.findAll();
		for(Participant part : participants)
		{
			Role role = part.getRole();
			if(role.getRoleId()==2)
			{
				teachers.add(part);
			}
		}
		model.addAttribute("participants", teachers);
		model.addAttribute("roles",roles);
		
		return "participants/participants";
	}
}
