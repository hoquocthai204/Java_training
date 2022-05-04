package net.sparkminds.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import net.sparkminds.user.entity.enumeration.CategoryStatus;
import validation.annotation.CategoryNameValidation;

public class CategoryRequestDTO {
	
	@NotBlank(message = "Name is required")
	@CategoryNameValidation(message = "Name is not allow")
	private String name;
	
	private String description;
	
	@NotNull(message = "Status is required")
	private CategoryStatus status;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CategoryStatus getStatus() {
		return status;
	}
	public void setStatus(CategoryStatus status) {
		this.status = status;
	}
}
