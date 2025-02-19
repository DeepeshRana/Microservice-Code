package in.pwskill.deepesh.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.pwskill.deepesh.entity.User;
import in.pwskill.deepesh.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public Integer saveUser(User user) {
		// Encode user password encoder
		String encode = passwordEncoder.encode(user.getUserPwd());
		user.setUserPwd(encode);
		return userRepository.save(user).getUserId();
	}

	public Optional<User> getOneUser(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		Optional<User> optional = userRepository.findByUserEmail(userEmail);
		if (optional.isPresent()) {
			User user = optional.get();
			List<SimpleGrantedAuthority> collect = user.getUserRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());

			// converting to user#security object for authentication
			return new org.springframework.security.core.userdetails.User(userEmail, user.getUserPwd(), collect);

		} else {
			throw new UsernameNotFoundException(userEmail + " not exist ");
		}
	}

}
