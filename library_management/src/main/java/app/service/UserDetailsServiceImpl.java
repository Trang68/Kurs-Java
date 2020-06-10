package app.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import app.entity.Clients;
import app.repository.ClientsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	 @Autowired
	 private ClientsRepository clientRepository;
	 
	 @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	 
    public UserDetails loadUserByUsername(String username) {
        Clients c = clientRepository.findClientBySeria(username);
        if (c == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        if (c.getPassportSeria().equals("admin")) {
        	 grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
        }

        return new org.springframework.security.core.userdetails.User(c.getPassportSeria(), bCryptPasswordEncoder.encode(c.getPassportNum()), grantedAuthorities);
    }
}
