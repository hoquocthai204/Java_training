package net.sparkminds.user.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.sparkminds.user.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
