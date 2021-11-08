package javabrain.pma.controller;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

@RequestMapping("/admin")
@Controller
public class AdminController {

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	Participant participant;
	
	@Autowired
	ParticipantRepository partRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	SubjectRepository subRepo;
	
	@GetMapping
	public String adminView()
	{
		return "redirect:/admin/dashbaord";
	}
	
	@GetMapping("/dashbaord")
	public String dashboard()
	{
		return "admin/admin-view";
	}
	
	@GetMapping("/teachers")
	public String showTeachers(Model model)
	{
		List<Participant> teachers = new Vector<Participant>();
		
		List<Participant> participants = partRepo.findAll();
		List<Role> roles = roleRepo.findAll();
		for(Participant part : participants)
		{
			Role role = part.getRole();
			if(role.getRoleId()==1)
			{
				teachers.add(part);
			}
		}
		model.addAttribute("participants", teachers);
		model.addAttribute("roles",roles);
		
		return "participants/participants";
	}
	
	@GetMapping("/employees")
	public String showEmployees(Model model)
	{
		List<Participant> employees = new Vector<Participant>();
		
		List<Participant> participants = partRepo.findAll();
		List<Role> roles = roleRepo.findAll();
		for(Participant part : participants)
		{
			Role role = part.getRole();
			if(role.getRoleId()==2)
			{
				employees.add(part);
			}
		}
		model.addAttribute("participants", employees);
		model.addAttribute("roles",roles);
		
		return "participants/participants";
	}
	
	@GetMapping("/admins")
	public String showAdmins(Model model)
	{
		List<Participant> admins = new Vector<Participant>();
		List<Participant> participants = partRepo.findAll();
		List<Role> roles = roleRepo.findAll();
		
		for(Participant part : participants)
		{
			Role role = part.getRole();
			if(role.getRoleId()==1)
			{
				admins.add(part);
			}
		}
		
		model.addAttribute("participants", admins);
		model.addAttribute("roles", roles);
		
		return "participants/participants";
	}
	
	@GetMapping("/students")
	public String showStudents(Model model)
	{
		List<Participant> students = new Vector<Participant>();
		List<Participant> participants = partRepo.findAll();
		List<Role> roles = roleRepo.findAll();
		
		for(Participant part : participants)
		{
			Role role = part.getRole();
			if(role.getRoleId()==4)
			{
				students.add(part);
			}
		}
		
		model.addAttribute("participants", students);
		model.addAttribute("roles", roles);
		
		return "participants/participants";
	}
	
	@GetMapping("/roles")
	public String showRoles(Model model)
	{
		List<Role> roles = roleRepo.findAll();
		model.addAttribute("roles", roles);
		return "roles/view-roles";
	}
	
	@GetMapping("roles/add")
	public String addRole(Model model)
	{
		model.addAttribute("role", new Role());
		return "roles/add-role";
	}
	@PostMapping("roles/save")
	public String saveRole(Role role)
	{
		roleRepo.save(role);
		
		return "redirect:/admin/dashboard/roles";
	}
	
	@GetMapping("/register")
	public String addParticipant(Model model)
	{
		List<Role> roles = roleRepo.findAll();
		model.addAttribute("roles",roles);
		model.addAttribute("participant", participant);
		return "admin/register-view";
	}
	
	@PostMapping("/save")
	public String saveParticipant(Model model, Participant participant)
	{
		Participant existingParticipant = partRepo.getParticipantByUsername(participant.getUsername());
		if(existingParticipant!=null)
		{
			return "redirect:/admin/dashboard/register?exist";
		}
		else
		{
			String rawPass = participant.getPassword();
			String encodedPass = encoder.encode(rawPass);
			participant.setPassword(encodedPass);
			partRepo.save(participant);	
		}
		
		return "redirect:/participants";
	}
}
