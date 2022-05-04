package net.sparkminds.user.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import net.sparkminds.user.entity.enumeration.CategoryStatus;

@Entity
@Table(name = "category")
@Data
public class Category extends Base {

	@Column(unique = true)
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private CategoryStatus status;
	
	@OneToMany(mappedBy = "category")
	private List<Image> images;

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

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

}
