package net.sparkminds.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sparkminds.user.dto.CategoryRequestDTO;
import net.sparkminds.user.entity.Category;
import net.sparkminds.user.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	private final CategoryService categoryService;
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("")
	public ResponseEntity<List<Category>> getListCategory() {
		return ResponseEntity.ok(categoryService.getAllCategory());
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> putCategory(@PathVariable("id") long id, @Valid @RequestBody CategoryRequestDTO categoryRequestDTO){
		categoryService.updateCategory(categoryRequestDTO, id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("")
	public ResponseEntity<Category> postCategory(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO){
		return ResponseEntity.ok(categoryService.createCategory(categoryRequestDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id){
		categoryService.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}
}
