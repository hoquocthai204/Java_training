package net.sparkminds.user.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.user.dto.ImageRequestDTO;
import net.sparkminds.user.entity.Image;
import net.sparkminds.user.reponsitory.ImageRepository;
import net.sparkminds.user.service.ImageService;

@Service
@Transactional(readOnly = true)
public class ImageServiceIml implements ImageService {

	@Autowired
	ImageRepository imageRepository;

	@Override
	@Transactional
	public void putImage(ImageRequestDTO imageRequestDTO, long id) {

		Image image = imageRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Image is not exist"));
		image.setTitle(imageRequestDTO.getTitle());
		image.setDescription(imageRequestDTO.getDescription());
		image.setUrlImage(imageRequestDTO.getUrlImage());
		image.setCategory(imageRequestDTO.getCategory());
	}

	@Override
	@Transactional
	public void deleteImage(long id) {
		imageRepository.deleteById(id);
	}

	@Override
	public List<Image> getListImage() {
		return imageRepository.findAll();
	}

	@Override
	@Transactional
	public Image postImage(ImageRequestDTO imageRequestDTO) {
		
		Image image = new Image();
		image.setTitle(imageRequestDTO.getTitle());
		image.setDescription(imageRequestDTO.getDescription());
		image.setUrlImage(imageRequestDTO.getUrlImage());
		image.setCategory(imageRequestDTO.getCategory());
		
		return imageRepository.save(image);
	}
}
