package net.sparkminds.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.APIResponse;
import net.sparkminds.user.dto.CategoryRequestDTO;
import net.sparkminds.user.entity.Category;
import net.sparkminds.user.reponsitory.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public APIResponse putData(CategoryRequestDTO categoryRequestDTO, long id) {
		APIResponse apiResponse = new APIResponse();

		Optional<Category> category = categoryRepository.findById(id);

		if (category.isPresent()) {
			Category _category = category.get();
			_category.setName(categoryRequestDTO.getName());
			_category.setDescription(categoryRequestDTO.getDescription());
			_category.setStatus(categoryRequestDTO.getStatus());

			if (_category.getStatus().equals("DELETED") || _category.getStatus().equals("ACTIVE")) {
				apiResponse.setData(categoryRepository.save(_category));
				return apiResponse;
			}
			apiResponse.setData("Status must be DELETED or ACTIVE");
			return apiResponse;
		}
		apiResponse.setData("category not found");
		return apiResponse;
	}

	public APIResponse postData(CategoryRequestDTO categoryRequestDTO) {
		APIResponse apiResponse = new APIResponse();

		Category category = new Category();

		category.setName(categoryRequestDTO.getName());
		category.setDescription(categoryRequestDTO.getDescription());
		category.setStatus(categoryRequestDTO.getStatus());

		if (category.getStatus().equals("DELETED") || category.getStatus().equals("ACTIVE")) {
			apiResponse.setData(categoryRepository.save(category));
			return apiResponse;
		}
		apiResponse.setData("Status must be DELETED or ACTIVE");

		return apiResponse;
	}

	public APIResponse deleteData(Long id) {
		APIResponse apiResponse = new APIResponse();
		
		try {
			categoryRepository.deleteById(id);
			apiResponse.setData("Category delete success");
			return apiResponse;
			
		} catch (Exception e) {
			apiResponse.setData("Category not found");
		}
		
		return apiResponse;
	}

}
