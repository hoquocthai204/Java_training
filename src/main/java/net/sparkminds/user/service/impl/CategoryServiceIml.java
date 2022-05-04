package net.sparkminds.user.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.user.dto.CategoryRequestDTO;
import net.sparkminds.user.entity.Category;
import net.sparkminds.user.reponsitory.CategoryRepository;
import net.sparkminds.user.service.CategoryService;

@Service
@Transactional(readOnly = true)
public class CategoryServiceIml implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	@Transactional
	public void updateCategory(CategoryRequestDTO categoryRequestDTO, long id) {

		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Category is not exist"));

		category.setName(categoryRequestDTO.getName());
		category.setDescription(categoryRequestDTO.getDescription());
		category.setStatus(categoryRequestDTO.getStatus());
	}

	@Override
	@Transactional
	public Category createCategory(CategoryRequestDTO categoryRequestDTO) {
		Category category = new Category();

		category.setName(categoryRequestDTO.getName());
		category.setDescription(categoryRequestDTO.getDescription());
		category.setStatus(categoryRequestDTO.getStatus());

		return categoryRepository.save(category);
	}

	@Override
	@Transactional
	public void deleteCategory(Long id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Category is not exist"));

		categoryRepository.delete(category);
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

}
