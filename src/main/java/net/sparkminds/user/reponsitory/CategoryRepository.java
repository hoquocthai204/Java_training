package net.sparkminds.user.reponsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.sparkminds.user.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	Category findOneById(long id);
}
