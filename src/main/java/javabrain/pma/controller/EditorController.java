package javabrain.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javabrain.pma.dao.ParticipantRepository;
import javabrain.pma.dao.RoleRepository;
import javabrain.pma.entities.Participant;

@RequestMapping("/editor")
@Controller
public class EditorController {
	
	@Autowired
	ParticipantRepository partRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@GetMapping
	public String editorView()
	{
		return "redirect:/editor/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboardView(Model model)
	{
		List<Participant> participans = partRepo.findAll();
		return "";
	}
	
	
}
