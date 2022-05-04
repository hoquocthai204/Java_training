package net.sparkminds.user.dto;


import javax.validation.constraints.NotBlank;

import net.sparkminds.user.entity.Category;

public class ImageRequestDTO {
	
	@NotBlank(message = "Title Image is required")
	private String title;
	
	private String description;
	
	private String urlImage;
	
	private Category category;
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
}
