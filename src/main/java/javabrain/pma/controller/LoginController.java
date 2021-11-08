package javabrain.pma.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javabrain.pma.dao.ParticipantRepository;
import javabrain.pma.entities.Participant;

@Controller
public class LoginController 
{
	@Autowired
	ParticipantRepository repo;
	
	@Autowired
	Participant participant;
	
	//Getting into the login view page, adding participant 
	//object into the model to bind form data 
	//of the view with the given object 
	//to authorize the data for login
	@GetMapping("/login")
	public String getLoginView(Model model)
	{
		model.addAttribute("user", participant);
		return "login/login-view";
	}
	
	//Getting the object binded with the data for verification and redirecting accordingly
	@PostMapping("/login/auth")
	public String getAuth(Participant user)
	{
		String username = user.getUsername();
		String password = user.getPassword();
		
		Participant authUser = repo.findByUsernameAndPassword(username, password);
		System.out.println(authUser +" "+ username +" "+ password);
		if(Objects.nonNull(authUser))
		{
			return "redirect:/dashboard";
		}
		else
		{
			return "redirect:/login?error";
		}
	}
	
	@GetMapping("/dashboard")
	public String getDashboard()
	{
		return "dashboard/admin-dash";
	}
}
