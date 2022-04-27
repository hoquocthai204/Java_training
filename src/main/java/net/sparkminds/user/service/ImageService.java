package net.sparkminds.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.APIResponse;
import net.sparkminds.user.dto.ImageRequestDTO;
import net.sparkminds.user.entity.Image;
import net.sparkminds.user.reponsitory.ImageRepository;

@Service
public class ImageService {
	
	@Autowired
	ImageRepository imageRepository;

	public APIResponse putData(ImageRequestDTO imageRequestDTO, long id) {
		APIResponse apiResponse = new APIResponse();
		
		Optional<Image> image = imageRepository.findById(id);
		if(image.isPresent()) {
			Image _image = image.get();
			_image.setTitle(imageRequestDTO.getTitle());
			_image.setDescription(imageRequestDTO.getDescription());
			_image.setUrlImage(imageRequestDTO.getUrlImage());
			_image.setCategory(imageRequestDTO.getCategory());
			apiResponse.setData(imageRepository.save(_image));
			return apiResponse;
		}
		
		apiResponse.setData("image not found");
		return apiResponse;
	}

	public APIResponse deleteData(long id) {
		APIResponse apiResponse = new APIResponse();
		try {
			imageRepository.deleteById(id);
			apiResponse.setData("image delete success");
			return apiResponse;
		} catch (Exception e) {
			apiResponse.setData("image not found");
		}
		return apiResponse;
	}

}
