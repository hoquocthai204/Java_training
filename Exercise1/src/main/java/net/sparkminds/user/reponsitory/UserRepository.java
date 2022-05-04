package net.sparkminds.user.reponsitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.sparkminds.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findOneByEmailAndPassword(String email, String password);
}
