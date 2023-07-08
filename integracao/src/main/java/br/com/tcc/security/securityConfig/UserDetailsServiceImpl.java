package br.com.tcc.security.securityConfig;

import br.com.tcc.entity.Ususario;
import br.com.tcc.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired(required=true)
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Ususario usuarioInexistente = new Ususario();
		usuarioInexistente.setId(0L);
		usuarioInexistente.setUserName("user");
		usuarioInexistente.setPassword("123");
		usuarioInexistente.setRoles(new ArrayList<>());

		Ususario usuario = userRepository.findByUserName(username).orElse(usuarioInexistente);
		
		return new User(usuario.getUsername(), 
						usuario.getPassword(), 
						true, 
						true, 
						true, 
						true, 
						usuario.getAuthorities());
	}
	
}
