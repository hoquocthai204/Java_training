package net.sparkminds.user.reponsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.sparkminds.user.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findOneByEmailAndPassword(String email, String password);
}
