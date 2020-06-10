package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired 
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	public void login(String username, String password) {
		 UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
		authenticationManager.authenticate(token);
		
		if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
        }
	}
}
