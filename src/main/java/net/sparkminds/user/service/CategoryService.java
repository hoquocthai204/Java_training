package net.sparkminds.user.service;

import java.util.List;

import net.sparkminds.user.dto.CategoryRequestDTO;
import net.sparkminds.user.entity.Category;

public interface CategoryService {
	void updateCategory(CategoryRequestDTO categoryRequestDTO, long id);
	Category createCategory(CategoryRequestDTO categoryRequestDTO);
	void deleteCategory(Long id);
	List<Category> getAllCategory();
}
