package javabrain.pma.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler 
{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) 
			throws IOException, ServletException {
		
		String targetUrl = determineTargetUrl(authentication);
		
		if(response.isCommitted())
		{
			return;
		}
		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(Authentication authentication) {
		
		
		String url = "/login?error";
		
		//getting roles
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		List<String> roles = new ArrayList<>();
		
		//getting roles into the list roles
		for(GrantedAuthority authority : authorities)
		{
			roles.add(authority.getAuthority());
		}
		
		//setting the url according to role
		if(roles.contains("Admin"))
		{
			url="/admin";
		}
		else if(roles.contains("Teacher"))
		{
			url="/teacher";
		}
		else if(roles.contains("Student"))
		{
			url="/student";
		}
		else if(roles.contains("Editor"))
		{
			url="/editor";
		}
		else if(roles.contains("Employee"))
		{
			url="/employee";
		}
		
		return url;
	}

}
