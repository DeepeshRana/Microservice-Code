package in.pwskill.deepesh.service;

import java.util.Optional;

import in.pwskill.deepesh.entity.User;

public interface UserService {
	
	Integer saveUser(User user);
	
	Optional<User> getOneUser(Integer id);

}
