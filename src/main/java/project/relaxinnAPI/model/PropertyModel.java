//This class is for creating Blue print/object of 'Property' entity
package project.relaxinnAPI.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class PropertyModel {
	// @Id annotation specifies the primary key of an entity
	@Id
	private String id;
	private String image;
	private String title;
	private String description;
	private Long price;
	private PropertyTypeModel type;
	private List<String> houseRules;	
	private List<String> amenities;
	private String location;
	private boolean bestSeller;
	
	public PropertyModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyModel(String id, String image, String title, String description, Long price, PropertyTypeModel type,
			List<String> houseRules, List<String> amenities, String location, boolean bestSeller) {
		super();
		this.id = id;
		this.image = image;
		this.title = title;
		this.description = description;
		this.price = price;
		this.type = type;
		this.houseRules = houseRules;
		this.amenities = amenities;
		this.location = location;
		this.bestSeller = bestSeller;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public PropertyTypeModel getType() {
		return type;
	}

	public void setType(PropertyTypeModel type) {
		this.type = type;
	}

	public List<String> getHouseRules() {
		return houseRules;
	}

	public void setHouseRules(List<String> houseRules) {
		this.houseRules = houseRules;
	}

	public List<String> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isBestSeller() {
		return bestSeller;
	}

	public void setBestSeller(boolean bestSeller) {
		this.bestSeller = bestSeller;
	}

	@Override
	public String toString() {
		return "PropertyModel [id=" + id + ", image=" + image + ", title=" + title + ", description=" + description
				+ ", price=" + price + ", type=" + type + ", houseRules=" + houseRules + ", amenities=" + amenities
				+ ", location=" + location + ", bestSeller=" + bestSeller + "]";
	}
}