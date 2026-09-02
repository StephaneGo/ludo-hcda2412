package fr.eni.ludotheque.security;

import fr.eni.ludotheque.bo.Utilisateur;
import fr.eni.ludotheque.dal.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService{

	private UtilisateurRepository utilisateurRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findByLogin(username);

		if(utilisateurOpt.isEmpty()){
			throw new UsernameNotFoundException(username + " non trouvé");
		}

		UserBuilder userBuilder = User.builder();
		userBuilder
				.username(username)
				.password(utilisateurOpt.get().getMotDePasse())
				.roles(utilisateurOpt.get().getRole());

		return userBuilder.build();
	}

}
