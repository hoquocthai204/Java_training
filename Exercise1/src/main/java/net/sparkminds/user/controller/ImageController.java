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

import net.sparkminds.user.dto.ImageRequestDTO;
import net.sparkminds.user.entity.Image;
import net.sparkminds.user.service.ImageService;

@RestController
@RequestMapping("/api/images")
public class ImageController {

	private final ImageService imageService;

	public ImageController(ImageService imageService) {
		this.imageService = imageService;
	}

	@GetMapping
	public ResponseEntity<List<Image>> getListImage() {
		return ResponseEntity.ok(imageService.getListImage());
	}

	@PostMapping
	public ResponseEntity<Image> portImage(@Valid @RequestBody ImageRequestDTO imageRequestDTO) {
		return ResponseEntity.ok(imageService.postImage(imageRequestDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> putImage(@PathVariable("id") long id, @Valid @RequestBody ImageRequestDTO imageRequestDTO) {
		imageService.putImage(imageRequestDTO, id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteImage(@PathVariable("id") long id) {
		imageService.deleteImage(id);
		return ResponseEntity.noContent().build();
	}
}
