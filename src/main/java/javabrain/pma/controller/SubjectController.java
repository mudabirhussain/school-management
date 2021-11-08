package javabrain.pma.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javabrain.pma.dao.ParticipantRepository;
import javabrain.pma.dao.SubjectRepository;
import javabrain.pma.entities.Participant;
import javabrain.pma.entities.Role;
import javabrain.pma.entities.Subject;

@RequestMapping("/subjects")
@Controller
public class SubjectController {

	@Autowired
	SubjectRepository subjectRepo;
	
	@Autowired
	Subject subject;
	
	@Autowired
	ParticipantRepository partRepo;
	
	@Autowired
	Participant participant;
	
	@GetMapping
	public String allSubject(Model model)
	{
		List<Subject> subjects = subjectRepo.findAll();
		model.addAttribute("subjects", subjects);
		return "subjects/subjects";
	}
	
	@GetMapping("/add")
	public String addSubject(Model model)
	{
		List<Participant> teachers = new ArrayList<Participant>();
		List<Participant> participants = partRepo.findAll();
		for(Participant part : participants)
		{
			Role role = part.getRole();
			long roleId = role.getRoleId();
			if(roleId==2)
			{
				teachers.add(part);
			}
		}
		model.addAttribute("teachers", teachers);
		model.addAttribute("subject", subject);
		//model.addAttribute("participant", participant);
		return "subjects/add-subject";
	}
	
	@PostMapping("/save")
	public String saveSubject(Subject subject, Model model)
	{
		subjectRepo.save(subject);
		
		return "redirect: /subjects";
	}
}
