package net.sparkminds.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import common.APIResponse;
import net.sparkminds.user.dto.ImageRequestDTO;
import net.sparkminds.user.entity.Image;
import net.sparkminds.user.reponsitory.ImageRepository;
import net.sparkminds.user.service.ImageService;

@RestController
public class ImageController {
	
	@Autowired
	ImageService imageService;
	
	@Autowired
	ImageRepository imageRepository;

	@RequestMapping("/api/images")
	public ResponseEntity<APIResponse> getList(){
		APIResponse apiResponse = new APIResponse();
		apiResponse.setData(imageRepository.findAll());
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	@RequestMapping(path = "/api/image",method = RequestMethod.POST)
	public ResponseEntity<APIResponse> portImage(@RequestBody ImageRequestDTO imageRequestDTO){
		
		APIResponse apiResponse = new APIResponse();
		
		Image image = new Image();
		
		image.setTitle(imageRequestDTO.getTitle());
		image.setDescription(imageRequestDTO.getDescription());
		image.setUrlImage(imageRequestDTO.getUrlImage());
		image.setCategory(imageRequestDTO.getCategory());
		
		apiResponse.setData(imageRepository.save(image));
		
		
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	@RequestMapping(path = "/api/image/{id}",method = RequestMethod.PUT)
	public ResponseEntity<APIResponse> putImage(@PathVariable("id") long id, @RequestBody ImageRequestDTO imageRequestDTO){
		APIResponse apiResponse = imageService.putData(imageRequestDTO,id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	@RequestMapping(path = "/api/image/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<APIResponse> deleteImage(@PathVariable("id") long id){
		APIResponse apiResponse = imageService.deleteData(id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
}
