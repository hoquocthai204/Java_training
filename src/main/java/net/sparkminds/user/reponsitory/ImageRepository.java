package net.sparkminds.user.reponsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.sparkminds.user.entity.Image;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {
	
}
