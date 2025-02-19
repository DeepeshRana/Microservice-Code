package in.pwskill.deepesh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskill.deepesh.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserEmail(String userEmail);

}
