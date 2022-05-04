package net.sparkminds.user.service;

import java.util.List;

import net.sparkminds.user.dto.ImageRequestDTO;
import net.sparkminds.user.entity.Image;

public interface ImageService {
	void putImage(ImageRequestDTO imageRequestDTO, long id);
	void deleteImage(long id);
	List<Image> getListImage();
	Image postImage(ImageRequestDTO imageRequestDTO);
}
