package net.sparkminds.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import common.APIResponse;
import net.sparkminds.user.dto.CategoryRequestDTO;
import net.sparkminds.user.reponsitory.CategoryRepository;
import net.sparkminds.user.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryService categoryService;

	@RequestMapping("/api/categories")
	public ResponseEntity<APIResponse> getList() {
		APIResponse apiResponse = new APIResponse();
		apiResponse.setData(categoryRepository.findAll());
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@RequestMapping(path = "/api/category/{id}", method = RequestMethod.PUT)
	public ResponseEntity<APIResponse> putCategory(@PathVariable("id") long id, @RequestBody CategoryRequestDTO categoryRequestDTO){
		APIResponse apiResponse = categoryService.putData(categoryRequestDTO, id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@RequestMapping(path = "/api/category", method = RequestMethod.POST)
	public ResponseEntity<APIResponse> postCategory(@RequestBody CategoryRequestDTO categoryRequestDTO){
		APIResponse apiResponse = categoryService.postData(categoryRequestDTO);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	@RequestMapping(path = "/api/category/{id}")
	public ResponseEntity<APIResponse> deleteCategory(@PathVariable("id") Long id){
		APIResponse apiResponse = categoryService.deleteData(id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
}
